public class SameOne
{
    static int numOfOnes(int n)
    {
        int c = 0;
        while (n != 0)
        {
            n &= (n - 1);
            ++c;
        }
        return c;
    }
    
    public static int next(int n)
    {
        int ones = numOfOnes(n);
        
        while (n < Integer.MAX_VALUE)
        {
            ++n;
            
            if (numOfOnes(n) == ones)
            {
                return n;
            }
        }
        return -1;
    }
    
    public static int prev(int n)
    {
        int ones = numOfOnes(n);
        
        while (n >= 0)
        {
            --n;
            
            if (numOfOnes(n) == ones)
            {
                return n;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int res = 0;
        int n = 0b11100100;
        
        res = SameOne.next(n);
        System.out.println("Next of " + Integer.toBinaryString(n) + " : " + Integer.toBinaryString(res));
        
        res = SameOne.prev(n);
        System.out.println("Prev of " + Integer.toBinaryString(n) + " : " + Integer.toBinaryString(res));
        
    }
}