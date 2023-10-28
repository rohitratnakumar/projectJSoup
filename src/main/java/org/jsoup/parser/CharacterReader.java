package org.jsoup.parser;

import org.jsoup.UncheckedIOException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.BufferPool;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

/**
 CharacterReader consumes tokens off a string. Used internally by jsoup. API subject to changes.
 */
public final class CharacterReader {
    static final char EOF = (char) -1;
    private static final int maxStringCacheLen = 12;
    static final int maxBufferLen = 1024 * 32; // visible for testing
    static final int readAheadLimit = (int) (maxBufferLen * 0.75); // visible for testing
    private static final int minReadAheadLen = 1024; // the minimum mark length supported. No HTML entities can be larger than this.

    private char[] charBuf;
    private Reader reader;
    private int bufLength;
    private int bufSplitPoint;
    private int bufPos;
    private int readerPos;
    private int bufMark = -1;
    private static final int stringCacheSize = 512;
    private String[] stringCache; // holds reused strings in this doc, to lessen garbage

    @Nullable private ArrayList<Integer> newlinePositions = null; // optionally track the pos() position of newlines - scans during bufferUp()
    private int lineNumberOffset = 1; // line numbers start at 1; += newlinePosition[indexof(pos)]

    /**
     Create a new CharacterReader that reads from the input Reader.
     @param input the Reader to read from. Need not be a BufferedReader, as CharacterReader maintains a buffer
     internally.
     */
    public CharacterReader(Reader input) {
        Validate.notNull(input);
        reader = input;
        charBuf = CharArrayPool.borrow();
        stringCache = StringCachePool.borrow();
        bufferUp();
    }

    /**
     @deprecated The initial buffer size parameter is no longer supported. This method will be removed in the next
     release.
     */
    @Deprecated
    public CharacterReader(Reader input, int sz) {
        this(input);
    }

    public CharacterReader(String input) {
        this(new StringReader(input));
    }

    public void close() {
        if (reader == null)
            return;
        try {
            reader.close();
        } catch (IOException ignored) {
        } finally {
            reader = null;
            CharArrayPool.release(charBuf);
            charBuf = null;
            StringCachePool.release(stringCache);
            stringCache = null;
        }
    }

    private boolean readFully; // if the underlying stream has been completely read, no value in further buffering

    private void bufferUp() {
        if (readFully || bufPos < bufSplitPoint)
            return;

        // discard the consumed characters from the buffer and pull the remainder forward:
        if (bufPos > 0) {
            int offset = bufMark == -1 ? bufPos : bufMark; // if set, mark is before pos
            int remainder = bufLength - offset;
            System.arraycopy(charBuf, offset, charBuf, 0, remainder);
            readerPos += offset;
            bufLength = remainder;
            if (bufMark != -1) {
                bufPos = bufMark;
                bufMark = 0;
            } else {
                bufPos = 0;
            }
        }

        // blocking read until we get the minimum buffered up, then read until would block
        try {
            while (bufLength <= minReadAheadLen || (bufLength < charBuf.length && reader.ready())) {
                int thisRead = reader.read(charBuf, bufLength, charBuf.length - bufLength);
                if (thisRead == -1) {
                    readFully = true;
                    break;
                }
                bufLength += thisRead;
                if (bufMark != -1) bufMark = 0;
                bufSplitPoint = Math.min(bufLength, readAheadLimit);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        scanBufferForNewlines(); // if enabled, we index newline positions for line number tracking
        lastIcSeq = null; // cache for last containsIgnoreCase(seq)
    }

    /**
     * Gets the position currently read to in the content. Starts at 0.
     * @return current position
     */
    public int pos() {
        return readerPos + bufPos;
    }

    /** Tests if the buffer has been fully read. */
    boolean readFully() {
        return readFully;
    }

    /**
     Enables or disables line number tracking. By default, will be <b>off</b>.Tracking line numbers improves the
     legibility of parser error messages, for example. Tracking should be enabled before any content is read to be of
     use.

     @param track set tracking on|off
     @since 1.14.3
     */
    public void trackNewlines(boolean track) {
        if (track && newlinePositions == null) {
            newlinePositions = new ArrayList<>(maxBufferLen / 80); // rough guess of likely count
            scanBufferForNewlines(); // first pass when enabled; subsequently called during bufferUp
        }
        else if (!track)
            newlinePositions = null;
    }

    /**
     Check if the tracking of newlines is enabled.
     @return the current newline tracking state
     @since 1.14.3
     */
    public boolean isTrackNewlines() {
        return newlinePositions != null;
    }

    /**
     Get the current line number (that the reader has consumed to). Starts at line #1.
     @return the current line number, or 1 if line tracking is not enabled.
     @since 1.14.3
     @see #trackNewlines(boolean)
     */
    public int lineNumber() {
        return lineNumber(pos());
    }

    int lineNumber(int pos) {
        // note that this impl needs to be called before the next buffer up or line numberoffset will be wrong. if that
        // causes issues, can remove the reset of newlinepositions during buffer, at the cost of a larger tracking array
        if (!isTrackNewlines())
            return 1;

        int i = lineNumIndex(pos);
        if (i == -1)
            return lineNumberOffset; // first line
        return i + lineNumberOffset + 1;
    }

    /**
     Get the current column number (that the reader has consumed to). Starts at column #1.
     @return the current column number
     @since 1.14.3
     @see #trackNewlines(boolean)
     */
    public int columnNumber() {
        return columnNumber(pos());
    }

    int columnNumber(int pos) {
        if (!isTrackNewlines())
            return pos + 1;

        int i = lineNumIndex(pos);
        if (i == -1)
          return pos + 1;
        return pos - newlinePositions.get(i) + 1;
    }

    /**
     Get a formatted string representing the current line and cursor positions. E.g. <code>5:10</code> indicating line
     number 5 and column number 10.
     @return line:col position
     @since 1.14.3
     @see #trackNewlines(boolean)
     */
    String cursorPos() {
        return lineNumber() + ":" + columnNumber();
    }

    private int lineNumIndex(int pos) {
        if (!isTrackNewlines()) return 0;
        int i = Collections.binarySearch(newlinePositions, pos);
        if (i < -1) i = Math.abs(i) - 2;
        return i;
    }

    /**
     Scans the buffer for newline position, and tracks their location in newlinePositions.
     */
    private void scanBufferForNewlines() {
        if (!isTrackNewlines())
            return;

        if (newlinePositions.size() > 0) {
            // work out the line number that we have read up to (as we have likely scanned past this point)
            int index = lineNumIndex(readerPos);
            if (index == -1) index = 0; // first line
            int linePos = newlinePositions.get(index);
            lineNumberOffset += index; // the num lines we've read up to
            newlinePositions.clear();
            newlinePositions.add(linePos); // roll the last read pos to first, for cursor num after buffer
        }

        for (int i = bufPos; i < bufLength; i++) {
            if (charBuf[i] == '\n')
                newlinePositions.add(1 + readerPos + i);
        }
    }

    /**
     * Tests if all the content has been read.
     * @return true if nothing left to read.
     */
    public boolean isEmpty() {
        bufferUp();
        return bufPos >= bufLength;
    }

    private boolean isEmptyNoBufferUp() {
        return bufPos >= bufLength;
    }

    /**
     * Get the char at the current position.
     * @return char
     */
    public char current() {
        bufferUp();
        return isEmptyNoBufferUp() ? EOF : charBuf[bufPos];
    }

    char consume() {
        bufferUp();
        char val = isEmptyNoBufferUp() ? EOF : charBuf[bufPos];
        bufPos++;
        return val;
    }

    /**
     Unconsume one character (bufPos--). MUST only be called directly after a consume(), and no chance of a bufferUp.
     */
    void unconsume() {
        if (bufPos < 1)
            throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume.")); // a bug if this fires, need to trace it.

        bufPos--;
    }

    /**
     * Moves the current position by one.
     */
    public void advance() {
        bufPos++;
    }

    void mark() {
        // make sure there is enough look ahead capacity
        if (bufLength - bufPos < minReadAheadLen)
            bufSplitPoint = 0;

        bufferUp();
        bufMark = bufPos;
    }

    void unmark() {
        bufMark = -1;
    }

    void rewindToMark() {
        if (bufMark == -1)
            throw new UncheckedIOException(new IOException("Mark invalid"));

        bufPos = bufMark;
        unmark();
    }

    /**
     * Returns the number of characters between the current position and the next instance of the input char
     * @param c scan target
     * @return offset between current position and next instance of target. -1 if not found.
     */
    int nextIndexOf(char c) {
        // doesn't handle scanning for surrogates
        bufferUp();
        for (int i = bufPos; i < bufLength; i++) {
            if (c == charBuf[i])
                return i - bufPos;
        }
        return -1;
    }

    /**
     * Returns the number of characters between the current position and the next instance of the input sequence
     *
     * @param seq scan target
     * @return offset between current position and next instance of target. -1 if not found.
     */
    int nextIndexOf(CharSequence seq) {
        bufferUp();
        // doesn't handle scanning for surrogates
        char startChar = seq.charAt(0);
        for (int offset = bufPos; offset < bufLength; offset++) {
            // scan to first instance of startchar:
            if (startChar != charBuf[offset])
                while(++offset < bufLength && startChar != charBuf[offset]) { /* empty */ }
            int i = offset + 1;
            int last = i + seq.length()-1;
            if (offset < bufLength && last <= bufLength) {
                for (int j = 1; i < last && seq.charAt(j) == charBuf[i]; i++, j++) { /* empty */ }
                if (i == last) // found full sequence
                    return offset - bufPos;
            }
        }
        return -1;
    }

    /**
     * Reads characters up to the specific char.
     * @param c the delimiter
     * @return the chars read
     */
    public String consumeTo(char c) {
        int offset = nextIndexOf(c);
        if (offset != -1) {
            String consumed = cacheString(charBuf, stringCache, bufPos, offset);
            bufPos += offset;
            return consumed;
        } else {
            return consumeToEnd();
        }
    }

    String consumeTo(String seq) {
        int offset = nextIndexOf(seq);
        if (offset != -1) {
            String consumed = cacheString(charBuf, stringCache, bufPos, offset);
            bufPos += offset;
            return consumed;
        } else if (bufLength - bufPos < seq.length()) {
            // nextIndexOf() did a bufferUp(), so if the buffer is shorter than the search string, we must be at EOF
            return consumeToEnd();
        } else {
            // the string we're looking for may be straddling a buffer boundary, so keep (length - 1) characters
            // unread in case they contain the beginning of the search string
            int endPos = bufLength - seq.length() + 1;
            String consumed = cacheString(charBuf, stringCache, bufPos, endPos - bufPos);
            bufPos = endPos;
            return consumed;
        }
    }

    /**
     * Read characters until the first of any delimiters is found.
     * @param chars delimiters to scan for
     * @return characters read up to the matched delimiter.
     */
    public String consumeToAny(final char... chars) {
        bufferUp();
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;
        final int charLen = chars.length;
        int i;

        OUTER: while (pos < remaining) {
            for (i = 0; i < charLen; i++) {
                if (val[pos] == chars[i])
                    break OUTER;
            }
            pos++;
        }

        bufPos = pos;
        return pos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }

    String consumeToAnySorted(final char... chars) {
        bufferUp();
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;

        while (pos < remaining) {
            if (Arrays.binarySearch(chars, val[pos]) >= 0)
                break;
            pos++;
        }
        bufPos = pos;
        return bufPos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }

    String consumeData() {
        // &, <, null
        //bufferUp(); // no need to bufferUp, just called consume()
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;

        OUTER: while (pos < remaining) {
            switch (val[pos]) {
                case '&':
                case '<':
                case TokeniserState.nullChar:
                    break OUTER;
                default:
                    pos++;
            }
        }
        bufPos = pos;
        return pos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }

    String consumeAttributeQuoted(final boolean single) {
        // null, " or ', &
        //bufferUp(); // no need to bufferUp, just called consume()
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;

        OUTER: while (pos < remaining) {
            switch (val[pos]) {
                case '&':
                case TokeniserState.nullChar:
                    break OUTER;
                case '\'':
                    if (single) break OUTER;
                case '"':
                    if (!single) break OUTER;
                default:
                    pos++;
            }
        }
        bufPos = pos;
        return pos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }


    String consumeRawData() {
        // <, null
        //bufferUp(); // no need to bufferUp, just called consume()
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;

        OUTER: while (pos < remaining) {
            switch (val[pos]) {
                case '<':
                case TokeniserState.nullChar:
                    break OUTER;
                default:
                    pos++;
            }
        }
        bufPos = pos;
        return pos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }

    String consumeTagName() {
        // '\t', '\n', '\r', '\f', ' ', '/', '>'
        // NOTE: out of spec, added '<' to fix common author bugs; does not stop and append on nullChar but eats
        bufferUp();
        int pos = bufPos;
        final int start = pos;
        final int remaining = bufLength;
        final char[] val = charBuf;

        OUTER: while (pos < remaining) {
            switch (val[pos]) {
                case '\t':
                case '\n':
                case '\r':
                case '\f':
                case ' ':
                case '/':
                case '>':
                case '<':
                    break OUTER;
            }
            pos++;
        }

        bufPos = pos;
        return pos > start ? cacheString(charBuf, stringCache, start, pos -start) : "";
    }

    String consumeToEnd() {
        bufferUp();
        String data = cacheString(charBuf, stringCache, bufPos, bufLength - bufPos);
        bufPos = bufLength;
        return data;
    }

    String consumeLetterSequence() {
        bufferUp();
        int start = bufPos;
        while (bufPos < bufLength) {
            char c = charBuf[bufPos];
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c))
                bufPos++;
            else
                break;
        }

        return cacheString(charBuf, stringCache, start, bufPos - start);
    }

    String consumeLetterThenDigitSequence() {
        bufferUp();
        int start = bufPos;
        while (bufPos < bufLength) {
            char c = charBuf[bufPos];
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c))
                bufPos++;
            else
                break;
        }
        while (!isEmptyNoBufferUp()) {
            char c = charBuf[bufPos];
            if (c >= '0' && c <= '9')
                bufPos++;
            else
                break;
        }

        return cacheString(charBuf, stringCache, start, bufPos - start);
    }

    String consumeHexSequence() {
        bufferUp();
        int start = bufPos;
        while (bufPos < bufLength) {
            char c = charBuf[bufPos];
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))
                bufPos++;
            else
                break;
        }
        return cacheString(charBuf, stringCache, start, bufPos - start);
    }

    String consumeDigitSequence() {
        bufferUp();
        int start = bufPos;
        while (bufPos < bufLength) {
            char c = charBuf[bufPos];
            if (c >= '0' && c <= '9')
                bufPos++;
            else
                break;
        }
        return cacheString(charBuf, stringCache, start, bufPos - start);
    }

    boolean matches(char c) {
        return !isEmpty() && charBuf[bufPos] == c;

    }

    boolean matches(String seq) {
        bufferUp();
        int scanLength = seq.length();
        if (scanLength > bufLength - bufPos)
            return false;

        for (int offset = 0; offset < scanLength; offset++)
            if (seq.charAt(offset) != charBuf[bufPos +offset])
                return false;
        return true;
    }

    boolean matchesIgnoreCase(String seq) {
        bufferUp();
        int scanLength = seq.length();
        if (scanLength > bufLength - bufPos)
            return false;

        for (int offset = 0; offset < scanLength; offset++) {
            char upScan = Character.toUpperCase(seq.charAt(offset));
            char upTarget = Character.toUpperCase(charBuf[bufPos + offset]);
            if (upScan != upTarget)
                return false;
        }
        return true;
    }

    boolean matchesAny(char... seq) {
        if (isEmpty())
            return false;

        bufferUp();
        char c = charBuf[bufPos];
        for (char seek : seq) {
            if (seek == c)
                return true;
        }
        return false;
    }

    boolean matchesAnySorted(char[] seq) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(seq, charBuf[bufPos]) >= 0;
    }

    boolean matchesLetter() {
        if (isEmpty())
            return false;
        char c = charBuf[bufPos];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    /**
     Checks if the current pos matches an ascii alpha (A-Z a-z) per https://infra.spec.whatwg.org/#ascii-alpha
     @return if it matches or not
     */
    boolean matchesAsciiAlpha() {
        if (isEmpty())
            return false;
        char c = charBuf[bufPos];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    boolean matchesDigit() {
        if (isEmpty())
            return false;
        char c = charBuf[bufPos];
        return (c >= '0' && c <= '9');
    }

    boolean matchConsume(String seq) {
        bufferUp();
        if (matches(seq)) {
            bufPos += seq.length();
            return true;
        } else {
            return false;
        }
    }

    boolean matchConsumeIgnoreCase(String seq) {
        if (matchesIgnoreCase(seq)) {
            bufPos += seq.length();
            return true;
        } else {
            return false;
        }
    }

    // we maintain a cache of the previously scanned sequence, and return that if applicable on repeated scans.
    // that improves the situation where there is a sequence of <p<p<p<p<p<p<p...</title> and we're bashing on the <p
    // looking for the </title>. Resets in bufferUp()
    @Nullable private String lastIcSeq; // scan cache
    private int lastIcIndex; // nearest found indexOf

    /** Used to check presence of </title>, </style> when we're in RCData and see a <xxx. Only finds consistent case. */
    boolean containsIgnoreCase(String seq) {
        if (seq.equals(lastIcSeq)) {
            if (lastIcIndex == -1) return false;
            if (lastIcIndex >= bufPos) return true;
        }
        lastIcSeq = seq;

        String loScan = seq.toLowerCase(Locale.ENGLISH);
        int lo = nextIndexOf(loScan);
        if (lo > -1) {
            lastIcIndex = bufPos + lo; return true;
        }

        String hiScan = seq.toUpperCase(Locale.ENGLISH);
        int hi = nextIndexOf(hiScan);
        boolean found = hi > -1;
        lastIcIndex = found ? bufPos + hi : -1; // we don't care about finding the nearest, just that buf contains
        return found;
    }

    @Override
    public String toString() {
        if (bufLength - bufPos < 0)
            return "";
        return new String(charBuf, bufPos, bufLength - bufPos);
    }

    /**
     * Caches short strings, as a flyweight pattern, to reduce GC load. Just for this doc, to prevent leaks.
     * <p />
     * Simplistic, and on hash collisions just falls back to creating a new string, vs a full HashMap with Entry list.
     * That saves both having to create objects as hash keys, and running through the entry list, at the expense of
     * some more duplicates.
     */
    private static String cacheString(final char[] charBuf, final String[] stringCache, final int start, final int count) {
        // limit (no cache):
        if (count > maxStringCacheLen)
            return new String(charBuf, start, count);
        if (count < 1)
            return "";

        // calculate hash:
        int hash = 0;
        for (int i = 0; i < count; i++) {
            hash = 31 * hash + charBuf[start + i];
        }

        // get from cache
        final int index = hash & stringCacheSize - 1;
        String cached = stringCache[index];

        if (cached != null && rangeEquals(charBuf, start, count, cached)) // positive hit
            return cached;
        else {
            cached = new String(charBuf, start, count);
            stringCache[index] = cached; // add or replace, assuming most recently used are most likely to recur next
        }

        return cached;
    }

    /**
     * Check if the value of the provided range equals the string.
     */
    static boolean rangeEquals(final char[] charBuf, final int start, int count, final String cached) {
        if (count == cached.length()) {
            int i = start;
            int j = 0;
            while (count-- != 0) {
                if (charBuf[i++] != cached.charAt(j++))
                    return false;
            }
            return true;
        }
        return false;
    }

    // just used for testing
    boolean rangeEquals(final int start, final int count, final String cached) {
        return rangeEquals(charBuf, start, count, cached);
    }

    // only useful for CharacterReader - does not reset so can be used across reads
    private static final BufferPool<String[]> StringCachePool =
        new BufferPool<>(2, new BufferPool.Lifecycle<String[]>() {

        @Override public String[] create() {
            return new String[stringCacheSize];
        }

        @Override public String[] reset(String[] arr) {
            // no-op as we don't grow, and want to reuse the contents between parses
            return arr;
        }
    });

    public static final BufferPool<char[]> CharArrayPool =
        new BufferPool<>(2, new BufferPool.Lifecycle<char[]>() {
            @Override public char[] create() {
                return new char[maxBufferLen];
            }

            @Override public char[] reset(char[] arr) {
                // no size check as it's fixed size
                Arrays.fill(arr, '\0'); // zero it to make sure we never inadvertently read stale input
                return arr;
            }
        });
}
