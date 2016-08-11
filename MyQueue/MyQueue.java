// Implement a MyQueue class which implements a queue using two stacks.
import java.util.Stack;

public class MyQueue<T>
{
    Stack<T> s1, s2;
    public MyQueue()
    {
        s1 = new Stack<T>();
        s2 = new Stack<T>();
    }
    
    void add(T value)
    {
        s1.push(value);
    }
    
    T remove()
    {
        if (s2.empty())                     
        {
            while (!s1.empty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    T peek()
    {
        if (s2.empty())
        {
            while (!s1.empty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    int size()
    {
        return s1.size() + s2.size();
    }
    
    public static void main(String[] args)
    {
        MyQueue<Integer> q = new MyQueue<Integer>();
        
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Peek: " + q.peek());
        System.out.println("Pop : " + q.remove());
        System.out.println("Pop : " + q.remove());
        q.add(5);
        q.add(6);
        while (q.size() != 0)
        {
            System.out.println("Pop : " + q.remove());
        }
    }
}