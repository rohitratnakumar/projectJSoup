/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 07 21:55:31 GMT 2018
 */

package org.jsoup.nodes;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.PseudoTextElement;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class FormElement_ESTest extends FormElement_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Tag tag0 = Tag.valueOf("method");
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "method", attributes0);
      // Undeclared exception!
      try { 
        formElement0.removeChild((Node) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.nodes.Node", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Tag tag0 = Tag.valueOf("disabled");
      CDataNode cDataNode0 = new CDataNode("");
      Attributes attributes0 = cDataNode0.attributes();
      FormElement formElement0 = new FormElement(tag0, "", attributes0);
      Elements elements0 = formElement0.elements();
      assertEquals(0, elements0.size());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ParseSettings parseSettings0 = ParseSettings.preserveCase;
      Tag tag0 = Tag.valueOf("k+Ri)[/H(zVMh", parseSettings0);
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "(Id", attributes0);
      // Undeclared exception!
      try { 
        formElement0.submit();
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Malformed URL: (Id
         //
         verifyException("org.jsoup.helper.HttpConnection", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Tag tag0 = Tag.valueOf("/nU,`#fdteA(s");
      CDataNode cDataNode0 = new CDataNode("");
      Attributes attributes0 = cDataNode0.attributes();
      FormElement formElement0 = new FormElement(tag0, "B", attributes0);
      Document document0 = new Document("");
      formElement0.addElement(document0);
      formElement0.formData();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Tag tag0 = Tag.valueOf("q");
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = null;
      try {
        formElement0 = new FormElement(tag0, (String) null, attributes0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Object must not be null
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ParseSettings parseSettings0 = ParseSettings.htmlDefault;
      Tag tag0 = Tag.valueOf("e", parseSettings0);
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "e", attributes0);
      formElement0.addElement((Element) null);
      // Undeclared exception!
      try { 
        formElement0.formData();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.nodes.FormElement", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ParseSettings parseSettings0 = ParseSettings.htmlDefault;
      Tag tag0 = Tag.valueOf("j6ueXB", parseSettings0);
      FormElement formElement0 = new FormElement(tag0, "$KqEv", (Attributes) null);
      // Undeclared exception!
      try { 
        formElement0.removeChild(formElement0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Must be true
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Tag tag0 = Tag.valueOf("zzf");
      CDataNode cDataNode0 = new CDataNode(".K,_H");
      Attributes attributes0 = cDataNode0.attributes();
      FormElement formElement0 = new FormElement(tag0, ".K,_H", attributes0);
      formElement0.appendTo(formElement0);
      formElement0.addElement(formElement0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ParseSettings parseSettings0 = new ParseSettings(false, false);
      Tag tag0 = Tag.valueOf("ins", parseSettings0);
      CDataNode cDataNode0 = new CDataNode("ins");
      Attributes attributes0 = cDataNode0.attributes();
      FormElement formElement0 = new FormElement(tag0, "ins", attributes0);
      formElement0.addElement(formElement0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Tag tag0 = Tag.valueOf("type");
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "", attributes0);
      formElement0.setSiblingIndex(2402);
      PseudoTextElement pseudoTextElement0 = new PseudoTextElement(tag0, "_}1M", attributes0);
      formElement0.addElement(pseudoTextElement0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ParseSettings parseSettings0 = ParseSettings.htmlDefault;
      Tag tag0 = Tag.valueOf("e", parseSettings0);
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "e", attributes0);
      formElement0.addElement((Element) null);
      formElement0.elements();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Tag tag0 = Tag.valueOf("type");
      Attributes attributes0 = new Attributes();
      FormElement formElement0 = new FormElement(tag0, "", attributes0);
      formElement0.prependChild(formElement0);
      formElement0.removeChild(formElement0);
  }
}
