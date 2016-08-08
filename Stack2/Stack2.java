// use a single array to implement three stacks.

public class Stack2
{
    int stackSize = 300;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};
    
    void push(int stackNum, int value)
    {
        if (stackNum >= 0 && stackNum < 3 && stackPointer[stackNum] < stackSize)
        {
            buffer[stackSize * stackNum + stackPointer[stackNum] + 1] = value;
            stackPointer[stackNum]++;
        }
        else
        {
            System.out.println("stack overflow");
        }
    }
    
    int pop(int stackNum)
    {
        if (stackPointer[stackNum] != -1)
        {
            int value = buffer[stackSize * stackNum + stackPointer[stackNum]];
            stackPointer[stackNum]--;
            return value;
        }
        else
        {
            System.out.println("stack underflow");
            return 0;
        }
    }
    
    int peak(int stackNum)
    {
        if (stackPointer[stackNum] >= 0)
        {
            return buffer[stackSize * stackNum + stackPointer[stackNum]];
        }
        else
        {
            System.out.println("stack underflow");
            return 0;
        }
    }
    
    boolean isEmpty(int stackNum)
    {
        return stackPointer[stackNum] == -1 ? true : false;
    }
    
    public static void main(String[] arg)
    {
        Stack2 s = new Stack2();
        s.push(1, 0);
        s.push(1, 1);
        s.push(1, 2);
        
        System.out.println(s.peak(1));
        while (!s.isEmpty(1))
        {
            System.out.print(s.pop(1) + " ");
        }
        System.out.println();
        

        for (int i = 0; i < 300; i++)
        {
            s.push(2, i);
        }
        while (!s.isEmpty(2))
        {
            System.out.print(s.pop(2) + " ");
        }
    }
}