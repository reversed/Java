// Code for find open number 1

byte[] bitfield = new byte[0xFFFFFFFF / 8];

void findOpenNumber1() throws FileNotFoundException
{
    Scanner in = new Scanner(new FileReader("input_file_4Billion_Integer.txt"));
    while (in.hasNextInt())
    {
        int n = in.nextInt();
        // Finds the corresponding number in the bitfield by using
        // the OR operator to set the nth bit of a byte (e.g. 10 would
        // correspond to the 2nd bit of index 2 in the byte array
        bitfield[n / 8] |= 1 << (n % 8);
    }
    
    for (int i = 0; i < bitfield.length; ++i)
    {
        for (int j = 0; j < 8; ++j)
        {
            // Retrieves the individual bits of each byte. When 0 bit
            // is found, finds the corresponding value
            if ((bitfield[i] & (1 << j)) == 0)
            {
                System.out.println(i * 8 + j);
                return;
            }
        }
    }
}

// Code for find open number 2
int bitsize = 1048567; // 2^20 bits (2^17 bytes)
int blockNum = 4096 // 2^12
byte[] bitfield = new byte[bitsize / 8];
int[] blocks = new int[blockNum];

void findOpenNumber2() throw FileNotFoundException
{
    int starting = -1;
    Scanner in = new Scanner(new FileReader("input_file_4Billion_Integer.txt"));
    while (in.hasNextInt())
    {
        int n = in.nextInt();
        ++blocks[n / (bitfield.length * 8)];
    }
    
    for (int i = 0; i < blocks.length; ++i)
    {
        if (block[i] < bitfield.length * 8)
        {
            // if value < 2^20, then at least 1 number is missing in that section
            starting = i * bifield.length * 8;
            break;
        }
    }
    
    in = new Scanner(new FileReader("input_file_4Billion_Integer.txt"));
    while (in.hasNextInt())
    {
        int n = in.nextInt();
        // If the number is inside the block that's missing numbers, we record it
        if (n >= starting && n < starting + bitfield.length * 8)
        {
            bitfield[(n - starting) / 8] |= 1 << ((n - starting) % 8);
        }
    }
    
    for (int i = 0; i < bitfield.length; ++i)
    {
        for (int j = 0; j < 8; ++j)
        {
            // Retrieve the individual bits of each byte. When 0 bit is found,
            // finds the corresponding value.
            if ((bitfield[i] & (1 << j)) == 0)
            {
                System.out.println(i * 8 + j + starting);
                return;
            }
        }
    }
}









