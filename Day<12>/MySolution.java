import java.io.*;
import java.util.*;

class GURU
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++)
                arr[i] = sc.nextInt();
                    
            Solution obj = new Solution();
            System.out.println(obj.sumBitDiff(arr,n));
        }
    }
}

class Solution
{
    public static long sumBitDiff(int arr[], int n)
    {               // O( NlogN ) Solution
        long even = 0L, zeros = 0L, diffSum = 0L;
        for ( int i=1; i<=32; i++ )
        {
            even = 0L;  zeros = 0L;
            for ( int j=0; j<n; j++ )
            {
                if ( arr[j] % 2 == 0 )
                    ++even;
                if ( arr[j] == 0 )
                    ++zeros;
                arr[j] /= 2;
            }
            if ( zeros == n )
                return 2*diffSum;
            diffSum += (even) * (n-even);
        }
        return 2*diffSum;
    }
}
