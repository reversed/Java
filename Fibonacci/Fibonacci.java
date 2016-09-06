public class Fibonacci
{
    public static int nth(int n)
    {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        
        return nth(n - 1) + nth(n - 2);
    }
    
    public static int nth2(int n)
    {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        
        int a = 1, b = 1;
        for (int i = 3; i <= n; ++i)
        {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    
    public static void main(String[] args)
    {
        int res = Fibonacci.nth2(10);
        System.out.println(res);
        res = Fibonacci.nth2(3);
        System.out.println(res);
    }
}