public class BiSearch
{
    public static int run(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] > target)
            {
                if (arr[low] <= target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if (arr[mid] < target)
            {
                if (arr[high] >= target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
        int idx = BiSearch.run(arr, 5);
        System.out.println(idx);
    }
}