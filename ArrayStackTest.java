import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Tests ArrayStack
 *
 */
public class ArrayStackTest
{
  public static void main(String args[]) {
    ArrayStackTest test = new ArrayStackTest();
    ArrayStack<Integer> stack = new ArrayStack<Integer>();
     //test.test_example();
    test.test_isEmpty(stack);
    test.test_peekTop(stack);
    test.test_pop(stack);
    test.test_push(stack);
   

  }
@Test
    public void test_isEmpty(Stack stack){
      assertTrue("Should be empty", stack.isEmpty());
      stack.push(1);
      assertTrue("Should NOT be empty", !stack.isEmpty());
      stack.pop(); //restart the stack
    }
    
    @Test
    public void test_peekTop(Stack stack){
      try{
        stack.peekTop(); //nothing in the stack
        fail("Should've thrown exception");
      } catch(Exception e){

      }
      stack.push(5);
      assertTrue("Should return 5", (int)stack.peekTop()==5);
      stack.pop(); //restart the stack
    }

    @Test
    public void test_pop(Stack stack){
      try{
        stack.pop(); //nothing in the stack
        fail("Should've thrown exception");
      }
      catch(Exception e){
      }
      stack.push(3);
      assertTrue("Should've removed it and returned the 3", (int)stack.pop()==3);
      assertTrue("Stack should be empty now", stack.isEmpty());
    }

    @Test
    public void test_push(Stack stack){
      stack.push(2);
      assertTrue("Should return 2", (int)stack.peekTop()==2);
    }


    /**
     * This is an example test.  After you have written your own tests,
     * get rid of it.
     
    @Test
    public void test_example() {
        assertTrue("it should be true", 5==5);
        assertEquals("they should be equal", 5, 5);
        // when comparing doubles, the last number is a threshold
        //   of how close the numbers should be to be considered equal
        assertEquals("they should be with .01 of each other", 5.12, 5.11, .01);
        if (false)
            fail("It should have been true");
    }
    */

}
