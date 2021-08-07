import java.io.*;
import java.util.*;

class GURU
{
    public static void main (String[] args)
    {
		Scanner ob = new Scanner(System.in);
		int t = ob.nextInt();
		while (t-->0)
		{
			long n = ob.nextLong();
			Solution ab = new Solution();
			long k = ab.findNth(n);
			System.out.println(k);
		}
	}
}

class Solution
{
    long findNth(long N)
    {
        StringBuilder sss = new StringBuilder("");
        while ( 0 < N )
        {
            sss.append(N % 9);
            N /= 9;
        }
        return Long.valueOf(sss.reverse().toString());
    }
}
