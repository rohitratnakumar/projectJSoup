/*
 * This file was automatically generated by EvoSuite
 * Sat Jun 16 21:58:35 GMT 2018
 */

package org.jsoup.select;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class NodeTraversor_ESTest extends NodeTraversor_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try { 
        NodeTraversor.traverse((NodeVisitor) null, (Elements) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Object must not be null
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try { 
        NodeTraversor.filter((NodeFilter) null, (Elements) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Object must not be null
         //
         verifyException("org.jsoup.helper.Validate", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      NodeTraversor.traverse((NodeVisitor) null, (Node) null);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      NodeFilter.FilterResult nodeFilter_FilterResult0 = NodeTraversor.filter((NodeFilter) null, (Node) null);
      assertEquals(NodeFilter.FilterResult.CONTINUE, nodeFilter_FilterResult0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      NodeTraversor nodeTraversor0 = new NodeTraversor((NodeVisitor) null);
      nodeTraversor0.traverse((Node) null);
  }
}
