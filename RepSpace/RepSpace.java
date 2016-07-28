public class RepSpace
{
	public static String Replace(String str)
	{
		char[] arr = str.toCharArray();
		String res = "";
		
		for (int i = 0; i < arr.length; ++i)
		{
			if (arr[i] == ' ')
			{
				res += "%20";
			}
			else
			{
				res += arr[i];
			}
		}
		return res;
	}
	
	public static void main(String[] arg)
	{
		String test = " Hello, Who's your daddy? ";
		String result = Replace(test);
		System.out.println("result: " + result);
	}
}







