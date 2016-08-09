// How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
// Push, pop and min should all operate in O(1) time.

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>
{
    Stack<Integer> s2;
    public StackWithMin2()
    {
        s2 = new Stack<Integer>();
    }
    
    public void push(int value)
    {
        if (value <= min())
        {
            s2.push(value);
        }
        super.push(value);
    }
    
    public Integer pop()
    {
        Integer value = super.pop();
        if(value == min())
        {
            s2.pop();
        }
        return value;
    }
    
    public int min()
    {
        if (s2.isEmpty())
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return s2.peek();
        }
    }
    
    public static void main(String[] arg)
    {
        StackWithMin2 s = new StackWithMin2();
        
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(-1);
        s.push(3);
        s.push(-2);
        
        System.out.println("peek top: " + s.peek());
        System.out.println("min top : " + s.min());
        s.pop();
        System.out.println("peek top: " + s.peek());
        System.out.println("min top : " + s.min());
        s.pop();
        System.out.println("peek top: " + s.peek());
        System.out.println("min top : " + s.min());
        s.pop();
        System.out.println("peek top: " + s.peek());
        System.out.println("min top : " + s.min());
    }
}