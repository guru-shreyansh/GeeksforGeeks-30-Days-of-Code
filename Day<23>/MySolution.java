import java.io.*;
import java.util.*;
import java.lang.*;

class Solution
{
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k)
	{
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i=0; i<n; i++)
		{
		    List<Integer> row = new ArrayList<Integer>();
		    row.add( Math.abs(arr[i]-x) );
		    row.add( arr[i] );
		    list.add(row);
		}
		list.sort( (l1, l2) -> l1.get(0).compareTo( l2.get(0) ) );
		
		List<Integer> last = List.of(100000000, 100000000);
		list.add( last );
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=0; i<k; i++)
		{
		    if ( list.get(i).get(0)==list.get(i+1).get(0) )
		    {
		        ArrayList<Integer> row = new ArrayList<Integer>();
		        row.add( list.get(i).get(1) );
		        while ( list.get(i).get(0)==list.get(i+1).get(0) )
		        {
		            row.add( list.get(i+1).get(1) );    ++i;
		        }
		        Collections.sort( row );
		        result.addAll(row);
		        continue;
		    }
		    result.add( list.get(i).get(1) );
		}
		Collections.sort( result );
		for (int i=k; i<result.size(); i++)
		    result.remove(i);
		return result;
	}
}

class GURU
{
    public static void main(String args[]) throws IOException
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
		{
        	int n = sc.nextInt();
        	int x = sc.nextInt();
        	int k = sc.nextInt();
        	int arr[] = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);
            for (int i=0; i<ans.size(); i++)
        	    System.out.print(ans.get(i)+" ");
            System.out.println();
            t--;
        }
    }
}
