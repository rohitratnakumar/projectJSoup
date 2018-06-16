/*
 * This file was automatically generated by EvoSuite
 * Sat Jun 16 22:08:54 GMT 2018
 */

package org.jsoup.parser;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jsoup.parser.ParseErrorList;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ParseErrorList_ESTest extends ParseErrorList_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.tracking((-1));
      boolean boolean0 = parseErrorList0.canAddError();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ParseErrorList parseErrorList0 = new ParseErrorList(0, 0);
      assertTrue(parseErrorList0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.noTracking();
      int int0 = parseErrorList0.getMaxSize();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.tracking((-1748));
      int int0 = parseErrorList0.getMaxSize();
      assertEquals((-1748), int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ParseErrorList parseErrorList0 = null;
      try {
        parseErrorList0 = new ParseErrorList((-191), 2976);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal Capacity: -191
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.tracking(1);
      boolean boolean0 = parseErrorList0.canAddError();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.tracking(1);
      int int0 = parseErrorList0.getMaxSize();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ParseErrorList parseErrorList0 = ParseErrorList.noTracking();
      boolean boolean0 = parseErrorList0.canAddError();
      assertFalse(boolean0);
  }
}
