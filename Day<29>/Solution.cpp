import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String str = sc.next();
                 
                    Sol obj = new Sol();
                    System.out.println(obj.maxFrequency(str));
                }
        }
}// } Driver Code Ends

class Sol
{
    
ArrayList<Integer> z_function(String s)
{
	int n = s.length();
	ArrayList<Integer> z = new ArrayList<Integer>(n);
	
	for(int i = 0 ;i<n;i++)
	    z.add(i,0);

	for(int i = 1, l = 0, r = 0; i < n; i++)
	{

		if(i <= r)
			z.set(i , Math.min(r - i + 1, z.get(i - l)) );
		
		while(i + z.get(i) < n && s.charAt(z.get(i)) == s.charAt(i + z.get(i)) )
			z.set(i , z.get(i) + 1);
		
		
		if(i + z.get(i) - 1 > r)
		{
			l = i;
			r = i + z.get(i) - 1;
		}
	}
	
    return z;
}
        
 
 
void update(int idx, int val, ArrayList<Integer> bit, int n)
{
	if(idx == 0)
		return;

	while(idx <= n)
	{
		bit.set(idx , bit.get(idx) + val);
		idx += (idx&-idx);
	}
}
 
 
int pref(int idx, ArrayList<Integer> bit)
{
	int ans = 0;
	while(idx > 0)
	{
		ans += bit.get(idx); 
		idx -= (idx&-idx);
	}	

	return ans;
}


int maxFrequency(String str)
{
	int n = str.length();
	ArrayList<Integer> z = z_function(str);
	

	ArrayList<Integer> bit = new ArrayList<Integer>(n + 5);
	for(int i = 0 ;i<n + 5;i++)
    	    bit.add(i,0);
	
	for(int i = 1; i < n; i++)
		update(z.get(i), 1, bit, n);


    TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();

	for(int i = n-1; i >= 1; i--)
	{
		if(z.get(i) != (n-i))
			continue;
		
		if(m.containsKey(z.get(i)))
		    {
		        m.put(z.get(i), m.get(z.get(i)) +   (pref(n, bit) - pref(z.get(i) - 1, bit) + 1)  ); 
		    }
		else
		    m.put(z.get(i) , (pref(n, bit) - pref(z.get(i) - 1, bit) + 1) );
	
	}
	
	int ans = 1;
	
	for(Map.Entry<Integer,Integer> entry : m.entrySet())
		ans = Math.max(ans, entry.getValue());

	return ans;
}
}
