// How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? 
// Push, pop and min should all operate in O(1) time.

class NodeWithMin
{
    int value;
    int min;
    NodeWithMin next = null;
    
    NodeWithMin(int v, int min)
    {
        value = v;
        this.min = min;
    }
}

public class StackWithMin
{
    NodeWithMin top = null;
    
    void push(int value)
    {
        if (top == null)
        {
            NodeWithMin n = new NodeWithMin(value, value);
            n.next = top;
            top = n;
        }
        else
        {
            int newMin = top.min < value ? top.min : value;
            NodeWithMin n = new NodeWithMin(value, newMin);
            n.next = top;
            top = n;
        }
    }
    
    int pop()
    {
        if (top != null)
        {
            int res = top.value;
            top = top.next;
            return res;
        }
        else
        {
            System.out.println("stack underflow.");
            return 0;
        }
    }
    
    int min()
    {
        return top.min;
    }
    
    int peek()
    {
        return top.value;
    }
    
    boolean empty()
    {
        return top == null;
    }
    
    public static void main(String[] arg)
    {
        StackWithMin s = new StackWithMin();
        
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(-1);
        s.push(3);
        s.push(-2);
        
        //while (!s.empty())
        //{
        //    System.out.print(s.pop() + " ");
        //}
        //System.out.println();
        
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