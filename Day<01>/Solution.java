import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while (t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            long a[] = new long[n];
            for (int i=0; i<n; i++)
                a[i] = Long.parseLong(input_line[i]);

            Solution obj = new Solution();
            obj.prank(a, n);

            for (int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }
    }
} // Driver Code Ends

class Solution
{
    void prank(long[] a, int n)
    {
        long N = n;
        for (int i = 0; i<n; i++)
            a[i] = a[i] + ( a[ (int)a[i] ] % N ) * N;

        for (int i=0; i<n; i++)
            a[i] = a[i] / N;
    }
}
