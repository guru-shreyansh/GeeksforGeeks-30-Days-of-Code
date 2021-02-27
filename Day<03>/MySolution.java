import java.io.*;
import java.util.*;

class GURU
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
        long currNumber = 1L;               // Minimum positive output
        for (int i=0; i<array.length; i++)
        {
            if (array[i] <= currNumber)
                currNumber += array[i];
            else
                break;
        }
        return currNumber;
    }
}
