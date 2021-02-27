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
}

class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        
        int stripSum[][] = new int[N][N],sum = 0; 
            
        for(int j=0;j<N;j++) 
        { 
            sum = 0;
            
            for (int i=0; i<K; i++) 
                sum += mat[i][j]; 
            
            stripSum[0][j] = sum; 
    
            for (int i=1; i<N-K+1; i++) 
            { 
                sum += (mat[i+K-1][j] - mat[i-1][j]); 
                stripSum[i][j] = sum; 
            } 
        } 
        
        int max_sum = Integer.MIN_VALUE; 
        for (int i=0; i<N-K+1; i++) 
        { 
            sum = 0; 
            for (int j = 0; j<K; j++) 
                sum += stripSum[i][j];
                
            if (sum > max_sum) 
                max_sum = sum;
    
            for (int j=1; j<N-K+1; j++) 
            { 
                sum += (stripSum[i][j+K-1] - stripSum[i][j-1]);
                if (sum > max_sum) 
                    max_sum = sum;
            } 
        }
        
        return max_sum;
    }
}
