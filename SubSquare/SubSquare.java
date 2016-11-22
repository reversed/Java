public class SubSquare
{
    public int row, column, size;
    public SubSquare(int r, int c, int sz)
    {
        row = r;
        column = c;
        size = sz;
    }

    public static SubSquare findSquare(int[][] matrix)
    {
        assert(matrix.length > 0);
        for (int row = 0; row < matrix.length; ++row)
        {
            assert(matrix[row].length == matrix.length);
        }
        
        int N = matrix.length;
        
        int currentMaxSize = 0;
        SubSquare sq = null;
        int col = 0;
        
        // Iterate through each column from left to right
        while (N - col < currentMaxSize)
        {
            for (int row = 0; row < matrix.length; ++row)
            {
                // starting from the biggest
                int size = N - Math.max(row, col);
                while (size > currentMaxSize)
                {
                    if (isSquare(matrix, row, col, size))
                    {
                        currentMaxSize = size;
                        sq = new SubSquare(row, col, size);
                        break;
                    }
                    --size;
                }
            }
            ++col;
        }
        return sq;
    }
    
    private static boolean isSquare(int[][] matrix, int row, int col, int size)
    {
        // Check top and bottom border
        for (int j = 0; j < size; ++j)
        {
            if (matrix[row][col + j] == 1)
            {
                return false;
            }
            if (matrix[row + size - 1][col + j] == 1)
            {
                return false;
            }
        }
        
        // Check left and right border
        for (int i = 1; i < size - 1; ++i)
        {
            if (matrix[row + i][col] == 1)
            {
                return false;
            }
            if (matrix[row + i][col + size - 1] == 1)
            {
                return false;
            }
        }
        return true;
    }
}






