import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.Maximum_Sum(a,n,k));
		}
	}
}// } Driver Code Ends
class Solution
{
    public int Maximum_Sum(int mat[][], int n, int k)
    {
        int[][] preSUM = new int[n-k+1][n]; // Array to store sum of all vertical 
        int i=0, j=0;                       //      sub-matrices of size 1*K
        for (j=0; j<n; j++)
            for (i=0; i<k; i++)
                preSUM[0][j] += mat[i][j];

        for (j=0; j<n; j++)
            for (i=1; i<=n-k; i++)
                preSUM[i][j] = preSUM[i-1][j] - mat[i-1][j] + mat[i+k-1][j];
        
        int currSUM = 0;                // Efficiently calculating sum of all possible
        int max = Integer.MIN_VALUE;    //          sub-matrices of size k*k
        for (i=0; i<n-k+1; i++)
        {
            currSUM = 0;
            for (j=0; j<k; j++)
                currSUM += preSUM[i][j];
            max = Math.max(max , currSUM);
            for (j=1; j<n-k+1; j++)
            {
                currSUM = currSUM - preSUM[i][j-1] + preSUM[i][j+k-1];
                max = Math.max(max , currSUM);
            }
        }
        return max;
    }
}
