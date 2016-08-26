public class SwapOddEven
{
    static int run(int n)
    {
        int mask = 0x55555555;
        int firstPass = n;
        firstPass = mask & firstPass;
        firstPass <<= 1;
        
        int secondPass = n;
        mask <<= 1;
        secondPass = mask & secondPass;
        secondPass >>= 1;
        
        return firstPass | secondPass;
    }
    
    static int run2(int n)
    {
        return (((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1));
    }
    
    public static void main(String[] args)
    {
        int res = SwapOddEven.run2(0b10101100);
        
        System.out.println("Swap: " + Integer.toBinaryString(res));
    }
}