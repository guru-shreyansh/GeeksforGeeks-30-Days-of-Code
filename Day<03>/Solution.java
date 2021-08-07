import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i=0; i<n; ++i)
            {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestpositive(array,n));
            t--;
        }
    }
}

class Solution
{
    long smallestpositive(long[] array, int n)
    {
        Arrays.sort(array);
        long result = 1;
        for (int i=0; i<n && array[i]<=result; i++)
            result = result + array[i];
        return result;
    }
}
