import java.io.*;

public class FindUnique {
	public static void testBufferedReader()
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a line: ");
		try
		{
			System.out.println(stdin.readLine());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static boolean isUniqueChars2(String str)
	{
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] arg)
	{
		String str = "";
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a string: ");
		try
		{
			str = stdin.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		boolean res = isUniqueChars2(str);
		System.out.println("Result: " + str + " is " + res);
	}
}
