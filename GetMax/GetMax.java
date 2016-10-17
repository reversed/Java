public class GetMax
{
    public static int run(int a, int b)
    {
        // rewording 1: if a > b, return a; else, return b
        // rewording 2: if (a - b) is negative, return b; else, return a;
        // rewording 3: if (a - b) is negative, let k = 1; else, let k = 0. Return a - k * (a - b).
        // rewording 4: Let c = a - b. Let k = the most significant bit of c. Return a - k * c.
        int c = a - b;
        int k = (c >> 31) & 0x1;
        int max = a - k * c;
        return max;
    }
    
    public static void main(String[] args)
    {
        int max = GetMax.run(10, 5);
        System.out.println(max);
    }
}