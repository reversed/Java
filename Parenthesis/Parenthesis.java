public class Parenthesis
{
    public static void printPar(int l, int r, char[] str, int count)
    {
        if (l < 0 || r < l) return;
        
        if (l == 0 && r == 0)
        {
            // found one, so print it
            System.out.println(str);
        }
        else
        {
            if (l > 0)
            {
                // try a left paren, if there are some available
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l)
            {
                // try a right paren, if there is a matching left
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }
    
    public static void print(int count)
    {
        char[] str = new char[count * 2];
        printPar(count, count, str, 0);
    }
    
    public static void main(String[] args)
    {
        Parenthesis.print(3);
    }
}