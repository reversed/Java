public class Queens
{
    int columnForRow[] = new int[8];
    int res = 0;
    
    boolean check(int row)
    {
        for (int i = 0; i < row; ++i)
        {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if (diff == 0 || diff == row - i)
            {
                return false;
            }
        }
        return true;
    }
    
    void place(int row)
    {
        if (row == 8)
        {
            ++res;
            return;
        }
        
        for (int i = 0; i < 8; ++i)
        {
            columnForRow[row] = i;
            if (check(row))
            {
                place(row + 1);
            }
        }
    }
    
    int get()
    {
        place(0);
        return res;
    }
    
    public static void main(String[] args)
    {
        Queens q = new Queens();
        System.out.println(q.get());
    }
}