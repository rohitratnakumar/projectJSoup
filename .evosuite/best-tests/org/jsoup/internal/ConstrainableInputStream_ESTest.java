/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 07 21:52:36 GMT 2018
 */

package org.jsoup.internal;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PushbackInputStream;
import java.io.SequenceInputStream;
import java.net.SocketTimeoutException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockFileInputStream;
import org.jsoup.internal.ConstrainableInputStream;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ConstrainableInputStream_ESTest extends ConstrainableInputStream_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pipedInputStream0, 1, 0);
      try { 
        constrainableInputStream0.readToByteBuffer(Integer.MAX_VALUE);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Pipe not connected
         //
         verifyException("java.io.PipedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pipedInputStream0, 1, 0);
      constrainableInputStream0.mark(1);
      constrainableInputStream0.reset();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      FileDescriptor fileDescriptor0 = new FileDescriptor();
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(fileDescriptor0);
      PushbackInputStream pushbackInputStream0 = new PushbackInputStream(mockFileInputStream0, 1256);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pushbackInputStream0, 1256, 0);
      byte[] byteArray0 = new byte[8];
      constrainableInputStream0.read(byteArray0, (int) (byte)0, 0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      FileDescriptor fileDescriptor0 = new FileDescriptor();
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(fileDescriptor0);
      // Undeclared exception!
      ConstrainableInputStream.wrap(mockFileInputStream0, Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      DataInputStream dataInputStream0 = new DataInputStream(pipedInputStream0);
      // Undeclared exception!
      try { 
        ConstrainableInputStream.wrap(dataInputStream0, (-3600), (-3600));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer size <= 0
         //
         verifyException("java.io.BufferedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pipedInputStream0, 1, 0);
      ConstrainableInputStream constrainableInputStream1 = constrainableInputStream0.timeout(0, (-2153L));
      try { 
        constrainableInputStream1.readToByteBuffer(0);
        fail("Expecting exception: SocketTimeoutException");
      
      } catch(SocketTimeoutException e) {
         //
         // Read timeout
         //
         verifyException("org.jsoup.internal.ConstrainableInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap((InputStream) null, 591, 1);
      byte[] byteArray0 = new byte[9];
      constrainableInputStream0.close();
      try { 
        constrainableInputStream0.read(byteArray0, 591, (int) (byte)66);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Stream closed
         //
         verifyException("java.io.BufferedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, (byte)1, (byte)36);
      // Undeclared exception!
      try { 
        constrainableInputStream0.read(byteArray0, (int) (byte)1, (-2005));
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.BufferedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      byte[] byteArray0 = new byte[3];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, 32768, 1);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, 1750, 1609);
      ConstrainableInputStream constrainableInputStream1 = constrainableInputStream0.timeout(1609, 2372000000L);
      // Undeclared exception!
      try { 
        constrainableInputStream1.read(byteArray0, (-1024), 3511);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.BufferedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, (byte)1, (byte)0);
      constrainableInputStream0.readToByteBuffer((byte)1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, (byte)19, (byte)0);
      constrainableInputStream0.readToByteBuffer(0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, (byte)1, (byte)36);
      constrainableInputStream0.readToByteBuffer(2468);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      byte[] byteArray0 = new byte[0];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, 32768, 32768);
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(byteArrayInputStream0, byteArrayInputStream0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(sequenceInputStream0, 32768, 0);
      constrainableInputStream0.readToByteBuffer(32768);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      byte[] byteArray0 = new byte[0];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, 32768, 32768);
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(byteArrayInputStream0, byteArrayInputStream0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(sequenceInputStream0, 32768, 0);
      // Undeclared exception!
      try { 
        constrainableInputStream0.readToByteBuffer((-165));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // maxSize must be 0 (unlimited) or larger
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      PushbackInputStream pushbackInputStream0 = new PushbackInputStream(pipedInputStream0, 1609);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pushbackInputStream0, 1609, 1609);
      constrainableInputStream0.timeout(1609, (-1L));
      byte[] byteArray0 = new byte[8];
      try { 
        constrainableInputStream0.read(byteArray0, 597, 0);
        fail("Expecting exception: SocketTimeoutException");
      
      } catch(SocketTimeoutException e) {
         //
         // Read timeout
         //
         verifyException("org.jsoup.internal.ConstrainableInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(byteArrayInputStream0, (byte)19, (byte)0);
      ConstrainableInputStream.wrap(constrainableInputStream0, 1, (byte)0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream(1);
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pipedInputStream0, 1, 1);
      try { 
        constrainableInputStream0.readToByteBuffer(1);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Pipe not connected
         //
         verifyException("java.io.PipedInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      // Undeclared exception!
      try { 
        ConstrainableInputStream.wrap((InputStream) null, 32768, (-3509));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Must be true
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      ConstrainableInputStream constrainableInputStream0 = ConstrainableInputStream.wrap(pipedInputStream0, 1, 0);
      try { 
        constrainableInputStream0.reset();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Resetting to invalid mark
         //
         verifyException("java.io.BufferedInputStream", e);
      }
  }
}
