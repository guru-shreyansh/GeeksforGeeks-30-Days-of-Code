import java.io.*;
import java.util.*;

class GfG
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
    int transfigure (String A, String B)
    {
    	if (A.length () != B.length ())
    	{
    	    return -1;
    	}
        
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
    	int n = A.length ();
    	for (int i = 0; i < n; i++)
		{
	    	if (m.containsKey(A.charAt(i)))
	        	m.put(A.charAt(i), m.get(A.charAt(i)) + 1);
	    	else
	        	m.put(A.charAt(i),1);
		}
		for (int i = 0; i < n; i++)
		{
	    	if (m.containsKey(B.charAt(i)))
	        	m.put(B.charAt(i),m.get(B.charAt(i)) - 1 );
		}
        for (Map.Entry<Character,Integer> entry : m.entrySet())
        {
            if (entry.getValue() != 0)
				return -1;
        }
    	
    	int i = n - 1, j = n - 1;
    	int res = 0;
    	while (i >= 0 && j >= 0)
    	{
    	    while (i >= 0 && A.charAt(i) != B.charAt(j))
    	    {
    			i--;
    			res++;
    	    }
	    	i--;
    	    j--;
    	}
    	return res;
    }
}
