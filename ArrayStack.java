/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author (your name)
 */
public class ArrayStack<E> implements Stack<E>
{
 Object[] stack = new Object[100];

 public boolean isEmpty() {
   for (int i=0; i<stack.length;i++){
    if (stack[i]==null)
     return false;
 }
 return true;
 }

    /** 
     * Return the value that pop would give, without modifying
     * the stack. TODO:  Throw a StackException if the stack is empty. 
     */
    public E peekTop(){
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

    }
}
