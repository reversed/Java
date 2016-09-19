import java.util.Comparator;
import java.util.Arrays;

public class AnagramSort
{
    public static void main(String[] args)
    {
        String[] arr = {
                        "abcde",
                        "dddfadf",
                        "dfakiadf",
                        "daf",
                        "daldf",
                       };
        Arrays.sort(arr, new AnagramComparator());
        
        for (int i = 0; i < arr.length; ++i)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}

class AnagramComparator implements Comparator<String>
{
    public String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    public int compare(String s1, String s2)
    {                                             
        return sortChars(s1).compareTo(sortChars(s2));
    }
}