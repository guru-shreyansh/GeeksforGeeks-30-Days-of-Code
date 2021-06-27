import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (0 < t)
	    {
            int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ; i++)
        	    array[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.RulingPair(array,n));
            t--;
        }
    } 
}

class Solution
{
	static int digitSum(int n)
	{
		int sum = 0;
		while (n != 0)
		{
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
	
	static int RulingPair(int arr[], int n)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < 1000 ; i++)
		{
			map.put(i, 0);
		}
		int ans = -1;
		for (int i = 0; i < n; i++)
		{
			int dSum = digitSum(arr[i]);
			if ((int)map.get(dSum) != 0)
			{
				ans = Math.max(ans, (int)map.get(dSum) + arr[i]);
			}
			mp.put(dSum,Math.max((int)map.get(dSum), arr[i]));
		}
		return ans;
	}
}
