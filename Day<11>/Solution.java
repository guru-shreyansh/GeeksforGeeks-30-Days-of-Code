import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String[] args) throws IOException
    {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int tc = Integer.parseInt(br.readLine());
	while (tc--> 0)
	{
	    String s = br.readLine().trim();
	    Solution sln = new Solution();
	    String ans = sln.compress(s);
	    System.out.println(ans);
	}
    }
}
class Solution
{
    void fillArray(String s, int[] a)
    {
	a[0] = 0;
	for (int i = 1; i<s.length(); i++)
	{
	    int series = a[i - 1];
	    while (series > 0)
	    {
		if (s.charAt(series) == s.charAt(i))
		{
		    a[i] = series + 1;
		    break;
		}
		series = a[series - 1];
	    }
	    if (series == 0)
	    {
		if (s.charAt(i) == s.charAt(0))
		    a[i] = 1;
		else
		    a[i] = 0;
	    }
	}
    }
    public String compress(String s)
    {
	int[] a = new int[s.length()];
		
	// ith element of array a stores the length of longest
        // proper suffix which is also a proper prefix for substr s[0] to s[i]
	fillArray(s, a);

	Stack<Character> shortened = new Stack<Character>();
		
        // for even index, string length is odd hence it cannot be divided into two
        // so we simply push ith character in stack
	for (int i = s.length() - 1; i > 0; i--)
	{
	    if (i % 2 == 0)
	    {
		shortened.push(s.charAt(i));
		continue;
	    }
            // star_here will be made TRUE if substring s[0] to s[i] can be divided into identical halves
	    boolean star_here = false;
			
	    // suffix and substring length are also meant for substring s[0] to s[i]
	    int suffix = a[i];
	    int substrlen = i + 1;
            
            // these conditions, if true, imply that, substring can be divided into 2 identical halves
	    if (suffix * 2 >= substrlen)
		if (substrlen % (substrlen - suffix) == 0)
		    if ((substrlen / (substrlen - suffix)) % 2 == 0)
			star_here = true;
            
            // adding * to stack and moving index as required
	    if (star_here == true)
	    {
		shortened.push('*');
		i = i / 2 + 1;
	    }	
            // else, simply adding character to stack
	    else
		shortened.push(s.charAt(i));
	}

	StringBuilder ret = new StringBuilder();
	ret.append(s.charAt(0));

        // since we analysed input string from end to start removing elements from stack and pushing back to
        // output string will reverse them back to required order
	while (!shortened.empty())
	{
	    ret.append(shortened.peek());
	    shortened.pop();
	}
	return ret.toString();
    }
}
