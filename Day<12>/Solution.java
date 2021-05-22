import java.io.*;
import java.util.*;
class GfG
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
    {
        long ans = 0;  // Initialize result
        // traverse over all bits
        for (int i = 0; i < 32; i++)
        {
            // count number of elements with i'th bit set
            int count = 0;
            for (int j = 0; j < n; j++)
                if ( (arr[j] & (1 << i)) != 0)
                    count++;
            // Add "count * (n - count) * 2" to the answer
            ans += (count * (n - count) * 2);
        }
        return ans;
    }
}
