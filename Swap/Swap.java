public class Swap
{
    public static void run(int a, int b)
    {
        System.out.println("Before: " + a + " " + b);
        
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        
        System.out.println("After: " + a + " " + b);
    }
    
    public static void main(String[] args)
    {
        Swap.run(1234, 5678);
    }
}