import java.util.*;

public class PostfixCalculator extends ArrayStack
{
  private String exp;
  public ArrayStack<Integer> nums;

  public PostfixCalculator(String expression){
     exp = expression;
    nums = new ArrayStack<Integer>();
  }

  public int evaluate(String expression) throws PostfixError{
    exp = expression;
    Scanner s = new Scanner(expression);
    String sign;
  
      if(s.hasNextInt())
    {
      int nextnum = s.nextInt();
      nums.push(nextnum);
    }else 
      throw new PostfixError(); // first num isn't an int


    if(s.hasNextInt())
    {
      int operand = s.nextInt();
      nums.push(operand);
    }else 
      throw new PostfixError(); //second num isn't an int


    while(s.hasNext()){
      if(s.hasNextInt())
        nums.push(s.nextInt());
      else //not an int --> it's a sign 
      {
        sign = s.next(); 
        operate(sign);
      }
    }

    //last integer is the answer
    int ans = nums.pop();
    s.close();
    if(nums.isEmpty()) //there shouldn't be anything else besides the answer
      return ans;
    else //no last integer
      throw new PostfixError(); //something went wrong if there's nothing left in the stack

  }


  public String toString(){
    String answer = exp+ " = "+ evaluate(exp); //original = evaluated expression
    return (answer);
  }
    

  public void operate(String sign){
   int temp1 = 0;
   int temp2 = 0;
   int ans = 0;

   if(sign.equals("+")){ //addition
      temp1 = nums.pop();
      temp2 = nums.pop();
      ans = temp1 + temp2;
      nums.push(ans);
    } else if(sign.equals("-")){ //subtractraction 
      temp1 = nums.pop();
      temp2 = nums.pop(); 
      ans = temp2 - temp1; //second minus first
      nums.push(ans);
    } else if(sign.equals("*")){ //multiplication
      temp1 = nums.pop();
      temp2 = nums.pop();
      ans = temp1*temp2;
      nums.push(ans);
    } else if(sign.equals("/")){ //division
      temp1 = nums.pop();
      temp2 = nums.pop();
      if(temp1 == 0){ //if divisor is 0
        throw new PostfixError(); //throw exception for dividing by 0
      }
      ans = temp2 / temp1; // second divided by first
      nums.push(ans);
    } else if(sign.equals("^")){ //exponentiation
      temp1 = nums.pop();
      temp2 = nums.pop();
      ans = (int)Math.pow(temp2, temp1); //second to the first power
      nums.push(ans);
    } else{ //not +, -, *, /, ^
      throw new PostfixError(); 
    }
  }

  }
