//Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, 
//we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure 
//SetOfStacks that mimics this. SetOfStacks should be composed of several stacks, and should create a new stack 
//once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to 
//a single stack (that is, pop() should return the same values as it would if there were just a single stack).

import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks
{
    int stackSize = 5;
    int Idx;
    int curSize;
    
    ArrayList<Stack<Integer>> arr = new ArrayList<Stack<Integer>>();
    
    SetOfStacks()
    {
        arr.add(new Stack<Integer>());
        Idx = 0;
        curSize = 0;
    }
    
    void push(int value)
    {
        arr.get(Idx).push(value);
        curSize++;

        if (curSize >= stackSize)
        {
            arr.add(new Stack<Integer>());
            Idx++;
            curSize = 0;
        }
    }
    
    int pop()
    {
        if (curSize <= 0)
        {
            Idx--;
            curSize = 5;
        }
        
        if (Idx >= 0)
        {
            int res = arr.get(Idx).pop();
            curSize--;
            
            return res;
        }
        else
        {
            System.out.println("stack underflow." + Idx + " " + curSize);
            Idx = 0;
            curSize = 0;
            return 0;
        }
    }
    
    boolean empty()
    {
        if (Idx <= 0 && curSize <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] arg)
    {
        SetOfStacks s = new SetOfStacks();
        
        for (int i = 0; i < 120; i++)
        {
            s.push(i);
        }
        for (int i = 0; i < 60; i++)
        {
            s.pop();
        }
        for (int i = 0; i < 30; i++)
        {
            s.push(i);
        }
        while (!s.empty())
        {
            //System.out.print(s.pop() + " ");
            System.out.println(s.pop() + " ");
        }
        s.pop();
        s.pop();
    }
}