/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 07 22:08:34 GMT 2018
 */

package org.jsoup.select;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.StructuralEvaluator;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class StructuralEvaluator_ESTest extends StructuralEvaluator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_Root0);
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Parent0.evaluator);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      Element element1 = mock(Element.class, new ViolatedAssumptionAnswer());
      doReturn((Elements) null).when(element1).getAllElements();
      // Undeclared exception!
      try { 
        structuralEvaluator_Has0.matches(element0, element1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.select.StructuralEvaluator$Has", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_Has0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_ImmediateParent0);
      structuralEvaluator_Not0.toString();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Has0);
      structuralEvaluator_ImmediatePreviousSibling0.toString();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has((Evaluator) null);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Has0);
      structuralEvaluator_ImmediatePreviousSibling0.matches((Element) null, (Element) null);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_Root0);
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Not0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_PreviousSibling0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Parent0);
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_ImmediatePreviousSibling0);
      structuralEvaluator_ImmediateParent0.toString();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has((Evaluator) null);
      structuralEvaluator_Has0.toString();
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Has0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_ImmediatePreviousSibling0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_Parent0);
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Not0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_PreviousSibling0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Has0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_ImmediatePreviousSibling0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_Parent0);
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Not0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      Element element1 = mock(Element.class, new ViolatedAssumptionAnswer());
      doReturn((Element) null).when(element1).previousElementSibling();
      structuralEvaluator_PreviousSibling0.matches(element0, element1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_Has0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_ImmediateParent0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_Root0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      Element element1 = mock(Element.class, new ViolatedAssumptionAnswer());
      doReturn((Element) null).when(element1).parent();
      structuralEvaluator_ImmediateParent0.matches(element0, element1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_Root0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_Not0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      Element element1 = mock(Element.class, new ViolatedAssumptionAnswer());
      doReturn((Element) null).when(element1).parent();
      structuralEvaluator_Parent0.matches(element0, element1);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_PreviousSibling0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_ImmediatePreviousSibling0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_Parent0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_PreviousSibling0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_ImmediatePreviousSibling0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_Not0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_Has0);
      structuralEvaluator_Not0.evaluator = (Evaluator) structuralEvaluator_Root0;
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_Not0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      structuralEvaluator_Root0.matches(element0, element0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_Root0);
      Element element0 = mock(Element.class, new ViolatedAssumptionAnswer());
      Element element1 = mock(Element.class, new ViolatedAssumptionAnswer());
      doReturn((Element) null).when(element1).parent();
      // Undeclared exception!
      try { 
        structuralEvaluator_Parent0.matches(element0, element1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jsoup.select.StructuralEvaluator$Parent", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      StructuralEvaluator.Root structuralEvaluator_Root0 = new StructuralEvaluator.Root();
      StructuralEvaluator.Has structuralEvaluator_Has0 = new StructuralEvaluator.Has(structuralEvaluator_Root0);
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_Has0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_ImmediateParent0);
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling(structuralEvaluator_Parent0);
      String string0 = structuralEvaluator_PreviousSibling0.toString();
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      StructuralEvaluator.PreviousSibling structuralEvaluator_PreviousSibling0 = new StructuralEvaluator.PreviousSibling((Evaluator) null);
      StructuralEvaluator.ImmediateParent structuralEvaluator_ImmediateParent0 = new StructuralEvaluator.ImmediateParent(structuralEvaluator_PreviousSibling0);
      StructuralEvaluator.Not structuralEvaluator_Not0 = new StructuralEvaluator.Not(structuralEvaluator_ImmediateParent0);
      StructuralEvaluator.ImmediatePreviousSibling structuralEvaluator_ImmediatePreviousSibling0 = new StructuralEvaluator.ImmediatePreviousSibling(structuralEvaluator_Not0);
      StructuralEvaluator.Parent structuralEvaluator_Parent0 = new StructuralEvaluator.Parent(structuralEvaluator_ImmediatePreviousSibling0);
      String string0 = structuralEvaluator_Parent0.toString();
      assertEquals(":parent:prev:not:ImmediateParent:prev*null", string0);
  }
}
