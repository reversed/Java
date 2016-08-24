import java.io.*;

public class PrintBinary
{
    public static String run(String n)
    {
        //System.out.println(n.substring(0, n.indexOf('.')));
        //System.out.println(n.substring(n.indexOf('.'), n.length()));
        
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
        
        String int_string = "";
        while(intPart > 0)
        {
            int r = intPart % 2;
            intPart >>= 1;
            int_string = r + int_string;
        }
        
        StringBuffer dec_string = new StringBuffer();
        while (decPart > 0)
        {
            if (dec_string.length() > 32) return "ERROR";
            
            double r = decPart * 2;
            if (r >= 1)
            {
                dec_string.append(1);
                decPart = r - 1;
            }
            else
            {
                dec_string.append(0);
                decPart = r;
            }
        }
        
        return int_string + "." + dec_string.toString();
    }
    
    public static void main(String[] args)
    {
        String str = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a decimal: ");
        try
        {
            str = stdin.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        String s = PrintBinary.run(str);
        System.out.println(s);
    }
}