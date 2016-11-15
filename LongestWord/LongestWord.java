import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord
{
    public static String run(String[] arr)
    {
        if (arr.length == 0) return null;
        
        LengthComparator lc = new LengthComparator();
        Arrays.sort(arr, lc);
        List lst = Arrays.asList(arr);
        
        
        for (int i = 0; i < arr.length; ++i)
        {
            String cur = arr[i];
            for (int end = 1; end < cur.length(); ++end)
            {
                String sub = cur.substring(0, end);
                if (lst.contains(sub))
                {
                    return cur;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        String[] arr = { "test", "tester", "testertest", "testing", "testingtester", "aadsafadsfkladsjfaf" };
        String s = LongestWord.run(arr);
        if (s != null)
            System.out.println(s);
        else
            System.out.println("No string found.");
    }
}

class LengthComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2)
    {
        if (o1.length() < o2.length()) return 1;
        if (o1.length() > o2.length()) return -1;
        return 0;
    }
}