import java.io.*;

public class ReverseStr
{
	public static String ReverseString(String str)
	{
		char[] arr = str.toCharArray();
		
		int start = 0;
		int end = str.length() - 1;
		while (start <= end)
		{
			char temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			++start;
			--end;
		}
		
		return str.valueOf(arr);
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
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		String rev = ReverseString(str);
		System.out.print("Reversed string: " + rev);
	}
}
