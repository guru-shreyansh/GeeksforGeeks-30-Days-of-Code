import java.io.*;
import java.util.*;

class GURU
{
    public static void main(String args[]) throws Exception
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
}

class Solution
{
    void prank(long[] arr, int n)
    {
        long temp = 0;
        long[] out = new long[n];
        for (int i=0; i<n; i++)
            out[i] = arr[ (int)arr[i] ];

        System.arraycopy(out, 0, arr, 0, n);
    }
}
