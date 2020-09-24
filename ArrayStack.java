/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author Avina Burns
 */
public class ArrayStack<E> implements Stack<E>
{
 Object[] stack = new Object[100];

 public boolean isEmpty() {
   for(int i = 0; i <stack.length; i++){
    if (stack[i]!=null)
     return false;
 }
 return true;
 }

    /** 
     * Return the value that pop would give, without modifying
     * the stack. TODO:  Throw a StackException if the stack is empty. 
     */
    public E peekTop(){
      if(isEmpty())
       return null;
      for(int i = stack.length-1; i >= 0; i--){
        if(stack[i] != null)
          return (E)stack[i];
      }
      return null;
    }

    /** 
     * Remove and return the value that has been in the stack the
     * least time. TODO: Throw a StackException if the stack is empty. 
     */
    public E pop(){

       Object temp = null;
       for (int i = stack.length; i>=0; i--){
         if (stack[i]!=null){
             temp = stack[i];
            stack[i]=null;
            break;
         }
       }
      return (E)temp;
    }

    
    /** 
     * Add the given value to the stack. 
     */
    public void push (E ob){
     if (stack[stack.length-1] !=null){
        int newlength = stack.length*2;
        Object[] tempstack = new Object[newlength];
        for (int i=0; i<stack.length; i++){ 
          tempstack[i] = stack[i];
        }
        stack = tempstack;
      }
       

     for(int i = stack.length-1; i >= 0; i--){
      if(stack[i] != null){
        stack[i+1] = ob;
        break;
      }
    }
    }
}
 