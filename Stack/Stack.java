import java.util.EmptyStackException;

class Node
{
    int data;
    Node next = null;
    
    Node(int i) { data = i; };
}

class Stack
{
    Node top = null;
    int pop()
    {
        if (top != null)
        {
            int item = top.data;
            top = top.next;
            return item;
        }
        throw new EmptyStackException();
    }
    
    void push(int item)
    {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }
    
    boolean isEmpty()
    {
        return top == null ? true : false;
    }
    
    public static void main(String[] arg)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while (!s.isEmpty())
        {
            System.out.print(s.pop() + " ");
        }
    }
}

