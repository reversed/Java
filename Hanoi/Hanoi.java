public class Hanoi
{
    public static void run(String src, String des, String mid, int n)
    {
        if (n > 0)
        {
            run(src, mid, des, n - 1);
            System.out.println(n + " : " + src + " -> " + des);
            run(mid, des, src, n - 1);
        }
    }
    
    public static void main(String[] arg)
    {
        Hanoi.run("x", "z", "y", 3);
    }
}