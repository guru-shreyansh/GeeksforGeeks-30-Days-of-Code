import java.io.*;
import java.util.*; 

class Solution
{
    static int catchThieves(char arr[], int n, int k)
	{
		int result = 0;
		ArrayList<Integer> thief = new ArrayList<Integer>();
		ArrayList<Integer> police = new ArrayList<Integer>();

		for (int i = 0; i < n; i++)
		{
			if (arr[i] == 'P')
				police.add(i);
			else if (arr[i] == 'T')
				thief.add(i);
		}

		// track lowest current indices of thief: thi[l], police: pol[r]
		int l = 0, r = 0;
		while (l < thief.size() && r < police.size())
		{
			// can be caught
			if (Math.abs(thief.get(l) - police.get(r)) <= k)
			{ 
				result++;
				l++;
				r++;
			}
			else if (thief.get(l) < police.get(r))
				l++;
			else
				r++;
		}
		return result;
	}
}

class GfG
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
