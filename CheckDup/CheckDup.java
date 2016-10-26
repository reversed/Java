public class CheckDup
{
    public static void check(int[] array)
    {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; ++i)
        {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0))
            {
                System.out.println(num);
            }
            else
            {
                bs.set(num0);
            }
        }
    }
}

class BitSet
{
    int[] bitset;
    
    public BitSet(int size)
    {
        bitset = new int[size >> 5]; // divide by 32
    }
    
    boolean get(int pos)
    {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }
    
    void set(int pos)
    {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitset[wordNumber] |= 1 << bitNumber;
    }
}