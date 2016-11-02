public class Shuffle
{
    public static void run(int[] cards)
    {
        int temp, index;
        for (int i = 0; i < cards.length; ++i)
        {
            index = (int)(Math.random() * (cards.length - i)) + i;
            temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        Shuffle.run(arr);
        for (int i : arr) System.out.println(i);
    }
}