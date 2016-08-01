public class ZeroMatrix
{
    public static void ZeroMat(int[][] arr, int n, int m)
    {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; ++i)
        {
            row[i] = 0;
        }
        for (int i = 0; i < m; ++i)
        {
            col[i] = 0;
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < m; j++)
            {
                if (row[i] == 1 || col[j] == 1)
                {
                    arr[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] arg)
    {
        int[][] arr = {
                          {1, 2, 3, 0, 5},
                          {0, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {0, 2, 3, 4, 5},
                        };

        ZeroMat(arr, 4, 5);
        
        for (int i = 0; i < 4; ++i)
        {
            for (int j = 0; j < 5; ++j)
            {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}




