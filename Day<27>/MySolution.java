import java.io.*;
import java.util.*;

class Solution
{
    static int catchThieves(char arr[], int n, int k)
	{
	    int max = 0;
	    boolean[] police = new boolean[n];  // Storing indices of Police
	    Arrays.fill(police , false);
	    
	    for (int i=0; i<n; i++)
	        if ( arr[i]=='P' )
	            police[i] = true;
	    outer:
	    for (int i=0; i<n; i++)             // Searching for the Thief
	    {
	        if ( arr[i]=='T' )
	        {
	            for (int j=i-k; j<=i+k; j++)
	            {
	                if (j<0 || j==i || n<=j)
	                    continue;
	                else if ( police[j]==true )
	                {
	                    police[j] = false;
	                    ++max;
	                    continue outer;
	                }
	            }
	        }
	    }
	    return max;
	}
}

class GURU
{
    public static void main(String args[]) throws IOException
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (0 < t)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for (int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}
