/**
 * ArrayStack should implement the Stack interface. You should write your own
 * test cases in ArrayStackTest
 *
 * @author (your name)
 */
public class ArrayStack<E> implements Stack<E> {
  Object[] stack = new Object[100];

  public boolean isEmpty() {
    for (int i = 0; i < stack.length; i++) {
      if (stack[i] != null)
        return false;
    }
    return true;
  }

  /**
   * Return the value that pop would give, without modifying the stack. 
   * Throw a StackException if the stack is empty.
   */
  public E peekTop() {
    if (isEmpty())
      throw new StackException();

    for (int i = stack.length - 1; i >= 0; i--) {
      if (stack[i] != null) {
        return (E) stack[i];
      }
    }
    return null;
  }

  /**
   * Remove and return the value that has been in the stack the least time. 
   * Throw a StackException if the stack is empty.
   */
  public E pop() {
    if (isEmpty())
      throw new StackException();

    Object temp = null;
    for (int i = stack.length - 1; i >= 0; i--) {
      if (stack[i] != null) {
        temp = stack[i];
        stack[i] = null;
        break;
      }
    }
    return (E) temp;
  }

  /**
   * Add the given value to the stack.
   */
  public void push(E ob) {

    for (int i = stack.length - 1; i >= 0; i--) {
      if (stack[i] != null && stack.length - 1 != i) {
        stack[i + 1] = ob;
        break;
      }
    }
    if (stack[0] == null)
      stack[0] = ob;
  }

}
