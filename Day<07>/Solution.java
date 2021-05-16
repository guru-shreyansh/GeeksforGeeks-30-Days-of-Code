import java.io.*;
import java.util.*; 

class GFG
{
    public static void main(String args[]) throws IOException
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
	{
            int n = sc.nextInt();
            int array[] = new int[n];
            for (int i=0; i<n; i++)
	    {
		array[i] = sc.nextInt();
	    }
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    }
}

class Solution
{
    static int lowerBound(int a[], int x)
    {
        int l = -1, r = a.length;
        while (l + 1 < r)
        {
            int m = (l+r)>>>1;
            
            if (a[m] >= x)
                r = m;
            else 
                l = m;
        }
        return r;
    }

    static long ValidPair(int a[], int n) 
    {
	Arrays.sort(a);
    	long ans = 0;
    	for (int i = 0; i < n; ++i)
	{
    	    if (a[i] <= 0)
    		continue;
    	    // search for first element >= (-a[i] + 1)
    	    int j = lowerBound(a, -a[i] + 1);
    	    ans += (i - j);
    	}
    	return ans;
    }
}
