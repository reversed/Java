public class StringSearch
{
    public static int run(String[] strings, String str)
    {
        int first = 0;
        int last = strings.length - 1;
        
        while (first <= last)
        {
            while (first <= last && strings[last].equals(""))
            {
                --last;
            }
            if (first > last)
            {
                return -1;
            }
            
            int mid = (first + last) / 2;
            while (strings[mid].equals(""))
            {
                ++mid;
            }
            
            int r = strings[mid].compareTo(str);
            
            if (r == 0) return mid;
            if (r < 0)
            {
                first = mid + 1;
            }
            else
            {
                last = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        String[] arr = { "at", "", "", "", "ball", "car", "", "", "car", "", "", "dad", "", "" };
        int res = StringSearch.run(arr, "ball");
        System.out.println(res);
        res = StringSearch.run(arr, "ballcar");
        System.out.println(res);
    }
}