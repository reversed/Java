import java.util.Arrays;

public class PairSum
{
    public static void print(int[] array, int sum)
    {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        
        while (first < last)
        {
            int s = array[first] + array[last];
            if (s == sum)
            {
                System.out.println(array[first] + " " + array[last]);
                ++first;
                --last;
            }
            else
            {
                if (s < sum) ++first;
                else --last;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = {-2, -1, 0, 3, 5, 6, 9, 7, 13};
        PairSum.print(arr, 6);
    }
}