/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 07 22:00:37 GMT 2018
 */

package org.jsoup.nodes;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.CharArrayWriter;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Comment_ESTest extends Comment_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Comment comment0 = new Comment("2BZ;6Z=g[79m", "");
      StringBuilder stringBuilder0 = new StringBuilder(0);
      Document.OutputSettings document_OutputSettings0 = new Document.OutputSettings();
      comment0.outerHtmlTail(stringBuilder0, 0, document_OutputSettings0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Comment comment0 = new Comment((String) null);
      comment0.getData();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Comment comment0 = new Comment("", "");
      comment0.getData();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Comment comment0 = new Comment("", "");
      comment0.setParentNode(comment0);
      // Undeclared exception!
      comment0.toString();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Comment comment0 = new Comment("", "");
      Comment comment1 = new Comment("", "");
      comment0.setParentNode(comment1);
      comment0.setSiblingIndex((-3204));
      // Undeclared exception!
      try { 
        comment0.toString();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: -3203
         //
         verifyException("java.util.Collections$EmptyList", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Comment comment0 = new Comment("`ovH");
      // Undeclared exception!
      try { 
        comment0.outerHtmlHead((Appendable) null, (-959), (Document.OutputSettings) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.nodes.Comment", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Comment comment0 = new Comment("");
      CharArrayWriter charArrayWriter0 = new CharArrayWriter();
      Document.OutputSettings document_OutputSettings0 = new Document.OutputSettings();
      // Undeclared exception!
      try { 
        comment0.outerHtmlHead(charArrayWriter0, (-1881), document_OutputSettings0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // width must be > 0
         //
         verifyException("org.jsoup.internal.StringUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Comment comment0 = new Comment((String) null, (String) null);
      // Undeclared exception!
      try { 
        comment0.isXmlDeclaration();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.nodes.Comment", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Comment comment0 = new Comment("CxTsyAQc");
      Tag tag0 = Tag.valueOf("CxTsyAQc");
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "noframes", attributes0);
      comment0.value = (Object) formElement0;
      // Undeclared exception!
      try { 
        comment0.isXmlDeclaration();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.jsoup.nodes.FormElement cannot be cast to java.lang.String
         //
         verifyException("org.jsoup.nodes.LeafNode", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Comment comment0 = new Comment("");
      // Undeclared exception!
      try { 
        comment0.asXmlDeclaration();
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Comment comment0 = new Comment((String) null, (String) null);
      // Undeclared exception!
      try { 
        comment0.asXmlDeclaration();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.nodes.Comment", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Comment comment0 = new Comment(" }!K31", " }!K31");
      // Undeclared exception!
      try { 
        comment0.asXmlDeclaration();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Comment comment0 = new Comment("{g4Z4BP0");
      Document document0 = Parser.parse("{g4Z4BP0", "{g4Z4BP0");
      Tag tag0 = document0.tag();
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "{g4Z4BP0", attributes0);
      comment0.value = (Object) formElement0;
      // Undeclared exception!
      try { 
        comment0.asXmlDeclaration();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.jsoup.nodes.FormElement cannot be cast to java.lang.String
         //
         verifyException("org.jsoup.nodes.LeafNode", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Comment comment0 = new Comment("AC#8iE", "");
      comment0.getData();
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Comment comment0 = new Comment("!\"rr3W", "!\"rr3W");
      comment0.nodeName();
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Comment comment0 = new Comment("1US", "");
      assertEquals(0, comment0.siblingIndex());
      assertEquals("#comment", comment0.nodeName());
      assertFalse(comment0.hasParent());
      assertNotNull(comment0);
      
      XmlDeclaration xmlDeclaration0 = comment0.asXmlDeclaration();
      assertEquals(0, comment0.siblingIndex());
      assertEquals("#comment", comment0.nodeName());
      assertFalse(comment0.hasParent());
      assertEquals(0, xmlDeclaration0.siblingIndex());
      assertFalse(xmlDeclaration0.hasParent());
      assertEquals("#declaration", xmlDeclaration0.nodeName());
      assertNotNull(xmlDeclaration0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Comment comment0 = new Comment("!\"rr3W", "!\"rr3W");
      assertFalse(comment0.hasParent());
      assertEquals("#comment", comment0.nodeName());
      assertEquals(0, comment0.siblingIndex());
      assertNotNull(comment0);
      
      boolean boolean0 = comment0.isXmlDeclaration();
      assertFalse(comment0.hasParent());
      assertEquals("#comment", comment0.nodeName());
      assertEquals(0, comment0.siblingIndex());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Comment comment0 = new Comment("", "");
      assertFalse(comment0.hasParent());
      assertEquals(0, comment0.siblingIndex());
      assertEquals("#comment", comment0.nodeName());
      assertNotNull(comment0);
      
      boolean boolean0 = comment0.isXmlDeclaration();
      assertFalse(comment0.hasParent());
      assertEquals(0, comment0.siblingIndex());
      assertEquals("#comment", comment0.nodeName());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Comment comment0 = new Comment("3Ylmks{2Hx9t{tg%1\"");
      assertEquals("#comment", comment0.nodeName());
      assertFalse(comment0.hasParent());
      assertEquals(0, comment0.siblingIndex());
      assertNotNull(comment0);
      
      StringBuilder stringBuilder0 = new StringBuilder((CharSequence) "3Ylmks{2Hx9t{tg%1\"");
      assertEquals("3Ylmks{2Hx9t{tg%1\"", stringBuilder0.toString());
      assertNotNull(stringBuilder0);
      
      Document.OutputSettings document_OutputSettings0 = new Document.OutputSettings();
      assertTrue(document_OutputSettings0.prettyPrint());
      assertEquals(Document.OutputSettings.Syntax.html, document_OutputSettings0.syntax());
      assertEquals(Entities.EscapeMode.base, document_OutputSettings0.escapeMode());
      assertFalse(document_OutputSettings0.outline());
      assertEquals(1, document_OutputSettings0.indentAmount());
      assertNotNull(document_OutputSettings0);
      
      Document.OutputSettings document_OutputSettings1 = document_OutputSettings0.prettyPrint(false);
      assertFalse(document_OutputSettings0.prettyPrint());
      assertEquals(Document.OutputSettings.Syntax.html, document_OutputSettings0.syntax());
      assertEquals(Entities.EscapeMode.base, document_OutputSettings0.escapeMode());
      assertFalse(document_OutputSettings0.outline());
      assertEquals(1, document_OutputSettings0.indentAmount());
      assertFalse(document_OutputSettings1.outline());
      assertEquals(Entities.EscapeMode.base, document_OutputSettings1.escapeMode());
      assertEquals(1, document_OutputSettings1.indentAmount());
      assertEquals(Document.OutputSettings.Syntax.html, document_OutputSettings1.syntax());
      assertFalse(document_OutputSettings1.prettyPrint());
      assertNotNull(document_OutputSettings1);
      assertSame(document_OutputSettings0, document_OutputSettings1);
      assertSame(document_OutputSettings1, document_OutputSettings0);
      
      comment0.outerHtmlHead(stringBuilder0, 40, document_OutputSettings0);
      assertEquals("#comment", comment0.nodeName());
      assertFalse(comment0.hasParent());
      assertEquals(0, comment0.siblingIndex());
      assertEquals("3Ylmks{2Hx9t{tg%1\"<!--3Ylmks{2Hx9t{tg%1\"-->", stringBuilder0.toString());
      assertFalse(document_OutputSettings0.prettyPrint());
      assertEquals(Document.OutputSettings.Syntax.html, document_OutputSettings0.syntax());
      assertEquals(Entities.EscapeMode.base, document_OutputSettings0.escapeMode());
      assertFalse(document_OutputSettings0.outline());
      assertEquals(1, document_OutputSettings0.indentAmount());
      assertSame(document_OutputSettings0, document_OutputSettings1);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Comment comment0 = new Comment(" }!K31", " }!K31");
      comment0.toString();
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Comment comment0 = new Comment(" }!K31", " }!K31");
      boolean boolean0 = comment0.isXmlDeclaration();
      assertFalse(boolean0);
      assertEquals("#comment", comment0.nodeName());
  }
}
