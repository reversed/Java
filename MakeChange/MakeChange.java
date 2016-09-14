public class MakeChange
{
    public static int run(int n, int denom)
    {
        int next_denom = 0;
        switch (denom)
        {
        case 25:
            next_denom = 10;
            break;
        case 10:
            next_denom = 5;
            break;
        case 5:
            next_denom = 1;
            break;
        case 1:
            return 1;
        }
        
        int ways = 0;
        for (int i = 0; i * denom <= n; ++i)
        {
            ways += run(n - i * denom, next_denom);
        }
        return ways;
    }
    
    public static int run(int n)
    {
        return run(n, 25);
    }
    
    public static void main(String[] args)
    {
        System.out.println(MakeChange.run(100));
        System.out.println(MakeChange.run(15));
    }
}