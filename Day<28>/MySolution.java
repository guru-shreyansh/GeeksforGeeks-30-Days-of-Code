import java.util.*;

class GURU
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
        while (t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            int gallery[] = new int[n];
            for (int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(sc.next());
            Solution T = new Solution();
            System.out.println(T.min_sprinklers(gallery,n));
        }
	}
}

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        ArrayList<ArrayList<Integer>> sprinklers = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<n; i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            if ( gallery[i] != -1 )
            {
                row.add( Math.max(0 , i-gallery[i]) );
                row.add( Math.min(i+gallery[i] , n-1) );
                sprinklers.add( row );
            }
        }
        sprinklers.sort( (l1, l2) -> l1.get(0).compareTo( l2.get(0) ) );
        // System.out.println( sprinklers );
        
        int curr = 0, ON = 0, i = 0;
        int maxRange = 0;
        while ( curr < n )
        {
            if ( sprinklers.size()<=i || curr < sprinklers.get(i).get(0) )
                return -1;
            maxRange = sprinklers.get(i).get(1);
            while ( i<sprinklers.size()-1 && sprinklers.get(i+1).get(0) <= curr )
            {
                ++i;
                maxRange = Math.max(sprinklers.get(i).get(1) , maxRange);
            }
            if (maxRange < curr)
                return -1;
            ++ON;       ++i;
            curr = maxRange+1;
        }
        return ON;
    }
}
