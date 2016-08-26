import java.util.ArrayList;

public class FindMissing
{
    public static int find(ArrayList<BitInteger> array)
    {
        return find2(array, BitInteger.INTEGER_SIZE - 1);
    }
    
    public static int find2(ArrayList<BitInteger> input, int column)
    {
        if (column < 0)
        {
            return 0;
        }
        
        ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
        ArrayList<BitInteger> evenIndices = new ArrayList<BitInteger>();
        
        for (BitInteger t : input)
        {
            if (t.fetch(column) == 0)
            {
                evenIndices.add(t);
            }
            else
            {
                oddIndices.add(t);
            }
        }
        
        if (oddIndices.size() >= evenIndices.size())
        {
            int res = (find2(evenIndices, column - 1)) << 1 | 0;
            //System.out.println(Integer.toBinaryString(res));
            return res;
        }
        else
        {
            int res = (find2(oddIndices, column - 1)) << 1 | 1;
            //System.out.println(Integer.toBinaryString(res));
            return res;
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<BitInteger> arr = new ArrayList<BitInteger>();
        int missing = 113;
        int maxVal = (int)Math.pow(2, BitInteger.INTEGER_SIZE);
        System.out.println("Max value: " + maxVal);

        for (int i = 0; i < maxVal; ++i)
        {
            if (i == missing) continue;
            
            arr.add(new BitInteger(i));
        }
        
        System.out.println("Find Missing: " + FindMissing.find(arr));
    }
}

class BitInteger
{
    public static final int INTEGER_SIZE = 8;
    int data;
    
    BitInteger(int i)
    {
        data = i;
    }
    
    public int fetch(int col)
    {
        if (col >= INTEGER_SIZE) return -1;
        
        int mov = INTEGER_SIZE - col - 1;
        
        int res = data;
        for (int i = 0; i < mov; ++i)
        {
            res >>= 1;
        }
        
        return res & 1;
    }
}