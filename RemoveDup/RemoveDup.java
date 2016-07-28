import java.io.*;
import java.util.Arrays;

public class RemoveDup
{
	public static void Remove(char[] arr)
	{
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; ++i)
		{
			int j = i + 1;
			
			while (j < arr.length && arr[i] == arr[j])
			{
				++j;
			}
			
			int k = i + 1;
			while (j < arr.length)
			{
				arr[k] = arr[j];
				++k;
				++j;
			}
			while (k < arr.length)
			{
				arr[k++] = 0;
			}
		}
	}
	
	public static void Remove2(char[] str)
	{
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		int tail = 1;
		for (int i = 1; i < len; ++i)
		{
			int j;
			for (j = 0; j < tail; ++j)
			{
				if (str[i] == str[j]) break;
			}
			if (j == tail)
			{
				str[tail] = str[i];
				++tail;
			}
		}
		while (tail < len) str[tail++] = 0;
	}
	
	public static void Remove3(char[] str)
	{
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i)
		{
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 0; i < len; ++i)
		{
			if (!hit[str[i]])
			{
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		while (tail < len) str[tail++] = 0;
	}
	
	public static void main(String[] arg)
	{
		String[] strs = {"abcde", "aaaaa", "", "aaaaaaaaaaaadddddddddddddddfkdfkaldfaijgalfadgjaldlfkakdflaldfklakjdfjg",
			        "a", "abbbba", "abcdea", "aabbcd", "aaabbb", "abababab"};
		
	    for (int i = 0; i < strs.length; ++i)
	    {
	    	char[] carr = strs[i].toCharArray();
	    	Remove3(carr);
	    	System.out.println(String.valueOf(carr));
	    }
	}
}