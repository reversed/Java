// Write a function to determine the number of bits required to convert integer A to integer B.

public class BitSwap
{
    static int numOfOnes(int n)
    {
        int c = 0;
        while (n > 0)
        {
            if ((n & 0x1) == 1)
            {
                ++c;
            }
            n >>= 1;
        }
        return c;
    }
    
    static int run(int n, int m)
    {
        int xor = n ^ m;
        
        return numOfOnes(xor);
    }
    
    public static void main(String[] args)
    {
        System.out.println(BitSwap.run(31, 14));
    }
}