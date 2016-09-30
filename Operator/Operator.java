public class Operator
{
    public static int FnNegate(int a)
    {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0)
        {
            neg += d;
            a += d;
        }
        return neg;
    }
    
    public static boolean DifferentSigns(int a, int b)
    {
        return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? true : false;
    }
    
    public static int abs(int a)
    {
        if (a < 0) return FnNegate(a);
        else return a;
    }
    
    public static int FnTimes(int a, int b)
    {
        if (a < b) return FnTimes(b, a); // faster if b < a
        int sum = 0;
        for (int iter = abs(b); iter > 0; --iter)
        {
            sum += a;
        }
        if (b < 0) sum = FnNegate(sum);
        return sum;
    }
    
    public static int FnDivide(int a, int b) throws java.lang.ArithmeticException
    {
        if (b == 0)
        {
            throw new java.lang.ArithmeticException("Divide by 0.");
        }
        int quotient = 0;
        int divisor = FnNegate(abs(b));
        for (int divend = abs(a); divend >= abs(divisor); divend += divisor)
        {
            ++quotient;
        }
        if (DifferentSigns(a, b)) quotient = FnNegate(quotient);
        return quotient;
    }
    
    public static void main(String[] args)
    {
        System.out.println(Operator.FnDivide(21, 3));
    }
}