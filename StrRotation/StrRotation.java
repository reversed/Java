public class StrRotation
{
    public static boolean isRotation(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        
        String test = s1 + s1;
        return test.contains(s2);
    }
    
    public static void main(String[] arg)
    {
        boolean res = false;
        
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        res = isRotation(s1, s2);
        System.out.println(res);
        
        s1 = "abc";
        s2 = "";
        res = isRotation(s1, s2);
        System.out.println(res);
        
        s1 = "abcdef";
        s2 = "efabcd";
        res = isRotation(s1, s2);
        System.out.println(res);
    }
}