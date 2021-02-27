import java.io.*;
import java.util.*;

class GFG
{
    public static void main (String[] args)
    {
		    Scanner ob=new Scanner(System.in);
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
    // function to change 'N' from base10 to base9
    long findNth(long N)
    {
        String s="";
        // taking remainders by 9 till N become 0
        while (N!=0)
        {
            s = (char)(N%9+'0') + s;
            N = N/9;
        }
        return Long.parseLong(s);
    }
}
