import java.util.*;

class GFG
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
				for (int j=0; j<m; j++ )
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
    public int findK(int a[][], int n, int m, int k)
    {
        int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;
        int dir = 0;
        int count = 0;
     
        while (top<=bottom && left<=right)
        {
            if (dir==0)
            {
                for (int i=left ;i<=right;i++)
                {
                    k--;
                    if (k == 0)
                        return (a[top][i]);
                }
                top++;
                dir=1;    
            }
            if (dir==1)
            {
                for(int i=top; i<=bottom; i++)
                {
                    k--;
                    if (k == 0)
                        return (a[i][right]);
                }
                right--;
                dir=2;   
            }
            if (dir==2)
            {
                for (int i=right;i>=left;i--)
                {
                    k--;
                    if (k == 0)
                        return (a[bottom][i]);
                }
                bottom--;
                dir=3;
            }
            if (dir==3)
            {
                for(int i=bottom;i>=top;i--)
                {
                    k--;
                    if(k == 0)
                    return (a[i][left]);
                }
                left++;
                dir=0;
            }
        }
        return -1;
    }
}
