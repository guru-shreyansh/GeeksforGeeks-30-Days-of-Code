import java.io.*;
import java.util.*;
class GURU
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            String arr[] = br.readLine().split(" ");
            String A = arr[0];
            String B = arr[1];
            Solution obj = new Solution();
            System.out.println(obj.transfigure (A, B));
       }
    }
}

class Solution
{
    int transfigure(String A, String B)
    {
        int i = 0, j = 0;
        int len = A.length();
        if ( len != B.length() ) return -1;
    	
    	char[] aaa = new StringBuilder(A).reverse().toString().toCharArray();
    	char[] bbb = new StringBuilder(B).reverse().toString().toCharArray();
    	int[] freq = new int[128];
    	
    	for (i = 0; i<len; i++)     ++freq[ (int)aaa[i] ];
    	for (i = 0; i<len; i++)     --freq[ (int)bbb[i] ];
    	for (i = 0; i<128; i++)
    	    if ( freq[i] != 0 )
    	        return -1;
    	
    	int matched = 0; i=j=0;
    	while ( j<len )
    	{
    	    while ( j<len && bbb[i]!=aaa[j] )
    	        ++j;
    	    if ( j<len )
    	    {
    	        ++i; ++j;
    	        ++matched;
    	    }
    	}
    	return len - matched;
    }
}
