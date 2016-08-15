import java.util.Stack;

public class SortStack
{
    static Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> r = new Stack<Integer>();
        
        while (!s.empty())
        {
            Integer tmp = s.pop();
            
            while (!r.empty() && r.peek() > tmp)
            {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        
        return r;
    }
    
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<Integer>();
        
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(2);
        s.push(5);
        s.push(0);
        
        Stack<Integer> r = sort(s);
        while (!r.empty())
        {
            System.out.print(r.pop() + " ");
        }
        System.out.println();
    }
}