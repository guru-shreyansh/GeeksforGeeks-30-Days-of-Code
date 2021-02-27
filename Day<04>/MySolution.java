import java.io.*;
import java.util.*;
class GURU
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n, k, ans;
            n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = sc.nextInt();
            k = sc.nextInt();
            Solution obj = new Solution();
            ans = obj.find_min(a, n, k);
            System.out.println(ans);
            t--;
        }
    }
}

class Solution
{
    public int find_min(int[] a, int n, int k)
    {
        if ( n==1 && 2*k<=a[0] ) return 2*k;
        else if ( n==1 && 2*k>a[0] ) return -1;
        int maxPossiblePairs = 0;
        int picks = n;
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> rest = new ArrayList<Integer>();
        for (int i=0; i<n; i++)
        {
            maxPossiblePairs += a[i]/2;
            --a[i];
            if ( a[i]%2 == 0 )
                even.add( a[i] );
            else 
                odd.add( a[i] );
        }
        if ( maxPossiblePairs < k )
            return -1;
        
        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());
        int i = 0;
        for (i=0; i<even.size() && 0<k; i++)
        {
            if ( even.get(i) < 2*k )
            {
                picks += even.get(i);
                k -= even.get(i)/2;
            }
            else if ( 2*k <= even.get(i) )
            {
                picks += 2*k-1;
                k -= k;
            }
            // System.out.println("Even -> k= "+k+" picks= "+picks);
        }
        for (i=0; i<odd.size() && 0<k; i++)
        {
            if ( odd.get(i) < 2*k )
            {
                picks += odd.get(i)-1;
                k -= (odd.get(i)-1)/2;
                rest.add(1);
            }
            else if ( 2*k <= odd.get(i) )
            {
                picks += 2*k-1;
                k -= k;
            }
        }
        i=0;
        while ( 0 < k && i<rest.size() )
        {
            k-=rest.get(i);
            picks+=rest.get(i);
            ++i;
        }
        // System.out.println("maxPossPair = "+maxPossiblePairs+" k = "+k+" picks = "+picks);
        if ( 0<k )
            return -1;
        
        return picks;
    }
}
