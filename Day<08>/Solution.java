import java.io.*;
import java.util.*;

class Solution
{
    static int maxCandy(int height[], int n)
    {
		// To store the maximum water so far
		int max = 0;

		// Both the pointers are pointing at the first and the last buildings respectively
		int i = 0, j = n - 1;
	
		// While the water can be stored between the currently chosen buildings
		while (i < j)
		{
	    	// Update maximum water so far and increment i
	    	if (height[i] < height[j])
	    	{
				max = Math.max(max, (j - i - 1) * height[i]);
				i++;
	    	}
	    	// Update maximum water so far and decrement j
	    	else if (height[j] < height[i])
	    	{
				max = Math.max(max, (j - i - 1) * height[j]);
				j--;
	    	}
	    	// Any of the pointers can be updated (or both)
	    	else
	    	{
				max = Math.max(max, (j - i - 1) * height[i]);
				i++;
				j--;
	    	}
		}
		return max;
    }
}

class GfG
{
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0)
		{
            int n = sc.nextInt();
            int height[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                height[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.maxCandy(height,n));
            t--;
        }
    }
}
