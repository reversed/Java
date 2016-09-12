enum Color
{
    B, W, R, Y, G
}

public class Paint
{
    public static void Fill(Color[][] screen, int x, int y, Color ocolor, Color ncolor)
    {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
        {
            return;
        }
        
        if (screen[y][x] == ocolor)
        {
            screen[y][x] = ncolor;
            Fill(screen, x - 1, y, ocolor, ncolor);
            Fill(screen, x + 1, y, ocolor, ncolor);
            Fill(screen, x, y - 1, ocolor, ncolor);
            Fill(screen, x, y + 1, ocolor, ncolor);
        }
    }
    
    public static void Fill(Color[][] screen, int x, int y, Color ncolor)
    {
        Fill(screen, x, y, screen[y][x], ncolor);
    }
    
    public static void main(String[] args)
    {
        Color screen[][] = {
                            {Color.W, Color.W, Color.W, Color.W, Color.W, Color.W},
                            {Color.W, Color.B, Color.B, Color.B, Color.B, Color.W},
                            {Color.W, Color.B, Color.R, Color.R, Color.B, Color.W},
                            {Color.W, Color.B, Color.R, Color.R, Color.B, Color.W},
                            {Color.W, Color.B, Color.B, Color.B, Color.B, Color.W},
                            {Color.W, Color.W, Color.W, Color.W, Color.W, Color.W},
                           };
        Paint.Fill(screen, 3, 3, screen[3][3], Color.Y);
        
        for (int i = 0; i < screen.length; ++i)
        {
            for (int j = 0; j < screen[i].length; ++j)
            {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}