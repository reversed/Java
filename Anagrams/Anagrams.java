import java.util.Arrays;

public class Anagrams
{
	public static boolean Decide(String s1, String s2)
	{
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2) return false;
		
		int[] count = new int[256];
		for (int i = 0; i < 256; ++i)
		{
			count[i] = 0;
		}
		
		for (int i = 0; i < len1; ++i)
		{
			count[s1.charAt(i)] += 1;
		}
		
		for (int i = 0; i < len2; ++i)
		{
			count[s2.charAt(i)] -= 1;
		}
		
		boolean res = true;
		for (int i = 0; i < 256; ++i)
		{
			if (count[i] != 0)
			{
				res = false;
				break;
			}
		}
		return res;
	}
	
	public static boolean Decide2(String s1, String s2)
	{
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		Arrays.sort(cs1);
		Arrays.sort(cs2);
		
		return Arrays.equals(cs1, cs2);
	}
	
	public static void main(String[] arg)
	{
		String[] test = {"abc", "cba", "aabbcc", "bbacac", "adfg", "adgh", "", "adf", "", ""};
		
		for (int i = 0; i < test.length; i += 2)
		{
			boolean res = Decide2(test[i], test[i + 1]);
			System.out.println("result: " + res);
		}
	}
}

