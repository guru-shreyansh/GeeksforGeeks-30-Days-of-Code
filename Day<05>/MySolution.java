import java.util.*;

class GURU
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for (int i=0; i<n; i++)
			{
				for (int j=0; j<m; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		    t--;
		}
	}
}

class Solution
{
    static int findK(int arr[][], int rowEnd, int columnEnd, int K)
	{
	    int k = 1;
	    int i, rowStart = 0, columnStart = 0;

		while (rowStart < rowEnd && columnStart < columnEnd)
		{
			for (i = columnStart; i < columnEnd; ++i, ++k)
			    if ( k==K )
			        return arr[rowStart][i];
			rowStart++;

			for (i = rowStart; i < rowEnd; ++i, ++k)
			    if ( k==K )
			        return arr[i][columnEnd - 1];
			columnEnd--;

			if (rowStart < rowEnd)
			{
				for (i = columnEnd - 1; i >= columnStart; --i, ++k)
				    if ( k==K )
				        return arr[rowEnd - 1][i];
				rowEnd--;
			}
			
			if (columnStart < columnEnd)
			{
				for (i = rowEnd - 1; i >= rowStart; --i, ++k)
				    if ( k==K )
				        return arr[i][columnStart];
				columnStart++;
			}
		}
		return -1;
	}
}
