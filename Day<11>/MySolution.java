import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		while (tc--> 0) {
			String s = br.readLine().trim();
			Solution sln = new Solution();
			String ans = sln.compress(s);
			System.out.println(ans);
		}
	}
}
// } Driver Code Ends
class Solution
{
    public String Compress(String s)
    {
        String sub = s.substring( 0,1 );
	    StringBuilder encrypted = new StringBuilder(sub);
	    
	    int i = 1;
	    while ( i<s.length() )
	    {
	        if ( s.indexOf(sub , i-1) != i )
	        {
	            sub = sub + String.valueOf(s.charAt(i));
	            encrypted.append(String.valueOf(s.charAt(i)));
	            ++i; continue;
	        }
	        if ( s.indexOf(sub , i-1) == i )
	        {
	            while(s.indexOf((sub+sub),i+sub.length()-1) == sub.length()+1)
	            {
	                sub = sub + sub;
	                encrypted.append(sub);
	                i = i+sub.length();
	            }
	            encrypted.append("*");
	            sub = sub + sub;
	            i = sub.length();
	        }
	    }
	    return sub.toString();
    }
	public String compress(String s)
	{
	    int i=0, n = s.length();
        ArrayList<Integer> pi = new ArrayList<Integer>(n);
	    for (i=0; i<n; i++)
            pi.add(0);
	    StringBuilder secC = new StringBuilder("");
	    for (i = 1; i < n; i++)
	    {
	        int j = pi.get(i-1);
	        while (j > 0 && s.charAt(i) != s.charAt(j))
	            j = pi.get(j-1);
	        if (s.charAt(i) == s.charAt(j))
	            j++;
	        pi.set(i,j);
	    }
	    for(i=n-1; i>=0; i--)
	    {
	        if(i%2 == 1)
	        {
	            if( pi.get(i)>=(i+1)/2 && (i+1)%(2*(i+1-pi.get(i)))==0 )
	            {
	                secC.append( "*" );
	                i/=2;
	                i++;
	            }
	            else 
	                secC.append(s.charAt(i));
	        }
	        else 
	            secC.append(s.charAt(i));
	    }
	    return secC.reverse().toString();
	}
}
