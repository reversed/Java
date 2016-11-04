public class RandomM
{
    public static int rand(int lower, int higher)
    {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }
    
    public static int[] pick(int[] original, int m)
    {
        int[] subset = new int[m];
        int[] array = original.clone();
        
        for (int j = 0; j < m; ++j)
        {
            int index = rand(j, array.length - 1);
            subset[j] = array[index];
            array[index] = array[j];
        }
        return subset;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res = RandomM.pick(arr, 5);
        for (int i : res)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}