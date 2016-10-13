public class Zeros
{
    public static int find(int num)
    {
        int count = 0;
        if (num < 0)
        {
            return 0;
        }
        
        for (int i = 5; num / i > 0; i *= 5)
        {
            count += num / i;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        int res = Zeros.find(26);
        System.out.println(res);
    }
}