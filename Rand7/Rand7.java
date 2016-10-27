// pseudo code for rand7() using rand5()

public static void rand7()
{
    while (true)
    {
        int num = 5 * (rand5() - 1) + (rand5() - 1);
        if (num < 21)
        {
            return (num % 7 + 1);
        }
    }
}
