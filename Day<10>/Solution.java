import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[]) throws IOException
    { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0)
		{
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    }
}

class Solution
{
    static boolean issubstring(String str2, String rep1)
    {
		int M = str2.length();
		int N = rep1.length();

		for (int i = 0; i <= N-M; i++)
		{
	    	int j;
	    	for (j = 0; j < M; j++)
			if (rep1.charAt(i + j) != str2.charAt(j))
		    	break;
	    	if (j == M)
				return true;
		}
		return false;
    }

    static int repeatedStringMatch(String A, String B)
    {
		int ans = 1;
		String S = A; 
		
		while (S.length() < B.length()) 
		{ 
	    	S += A; 
	    	ans++; 
		} 
		if (issubstring(B, S)) return ans; 
		if (issubstring(B, S + A)) 
	    	return ans + 1; 
		return -1; 
    } 
}
