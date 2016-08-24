public class UpdateBit
{
    public static int update(int n, int m, int l, int r)
    {
        int n2 = n;
        int test = 1;
        for (int i = 0; i < 32; ++i)
        {
            if (i >= r && i <= l)
            {
                n2 = n2 | test;
            }
            test <<= 1;
        }

        int m2 = m << r;
        test = 1;
        for (int i = 0; i < 32; ++i)
        {
            if (i < r || i > l)
            {
                m2 = m2 | test;
            }
            test <<= 1;
        }

        return n2 & m2;
    }
    
    public static int update2(int n, int m, int l, int r)
    {
        int max = ~0;
        
        int left = max - ((1 << l) - 1);
        
        int right = ((1 << r) - 1);
        
        int mask = left | right;
        
        return (n & mask) | (m << r);
    }
    
    public static void main(String[] args)
    {
        int n = 0b10000000000;
        int m = 0b10101;
        int i = 2, j = 6;
        
        //int res = UpdateBit.update(n, m, j, i);
        int res = UpdateBit.update2(n, m, j, i);
        
        System.out.println(Integer.toBinaryString(res));
    }
}








