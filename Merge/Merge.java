public class Merge
{
    public static void run(int[] arr1, int[] arr2, int n, int m)
    {
        int k = n + m - 1;
        int idx1 = n - 1;
        int idx2 = m - 1;
        
        while (idx1 >= 0 && idx2 >= 0)
        {
            if (arr1[idx1] > arr2[idx2])
            {
                arr1[k--] = arr1[idx1--];
            }
            else
            {
                arr1[k--] = arr2[idx2--];
            }
        }
        while (idx2 >= 0)
        {
            arr1[k--] = arr2[idx2--];
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr1 = {1, 10, 12, 13, 23, 45, 100, 102, 109, 200};
        int[] arr2 = {2, 3, 4, 5, 50, 75, 100, 125};
        
        int[] res = new int[100];
        System.arraycopy(arr1, 0, res, 0, arr1.length);
        
        Merge.run(res, arr2, 10, 8);
        
        for (int i = 0; i < 100; ++i)
        {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}