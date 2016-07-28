public class Rotate
{
	public static void Rotate(int arr[][], int n)
	{
		for (int layer = 0; layer < n / 2; ++layer)
		{
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i)
			{
				int offset = i - first;
				int top = arr[first][i];
				
				// left -> top
				arr[first][i] = arr[last - offset][first]; 
				// bottom -> left
				arr[last - offset][first] = arr[last][last - offset];
				// right -> bottom
				arr[last][last - offset] = arr[i][last];
				// top -> right
				arr[i][last] = top;
			}
		}
	}
	
	public static void main(String[] arg)
	{
		int[][] arr = { 
			            { 1,  2,  3,  4,  5},
			            { 6,  7,  8,  9, 10},
			            {11, 12, 13, 14, 15},
			            {16, 17, 18, 19, 20},
			            {21, 22, 23, 24, 25},
                      };
		Rotate(arr, 5);
		
		for (int i = 0; i < 5; ++i)
		{
			for (int j = 0; j < 5; ++j)
			{
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println("");
		}
	}
}





