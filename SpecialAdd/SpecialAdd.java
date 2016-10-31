public class SpecialAdd
{
    public static int run(int a, int b)
    {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return run(sum, carry);
    }
    
    public static void main(String[] args)
    {
        int res = SpecialAdd.run(759, 674);
        System.out.println(res);
    }
}