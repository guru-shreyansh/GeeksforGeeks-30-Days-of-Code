import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(sc.next());
            Solution T = new Solution();
            System.out.println(T.min_sprinklers(gallery,n));
        }
		
		
	}
}




// } Driver Code Ends

class Pair{
   int x;
   int y;
   public Pair(int x,int y)
   {
       this.x = x;
       this.y = y;
   }
}

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        List <Pair> sprinklers = new ArrayList<>();
        for(int i=0; i<n; i++)
            if(gallery[i] > -1)
                sprinklers.add( new Pair( i-gallery[i], i+gallery[i] ) );
        
        Collections.sort(sprinklers, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2)
            {
                return p1.x - p2.x;
            }
            
        });
        
        int target=0, sprinklers_on=0, i=0;
        while(target<n)
        {
            if(i==sprinklers.size() || sprinklers.get(i).x>target)
                return -1;
            
            int max_range = sprinklers.get(i).y;
            while( i+1<sprinklers.size() && sprinklers.get(i+1).x<=target )
            {
                i++;
                max_range = Math.max( max_range,  sprinklers.get(i).y );
            }
            if(max_range<target)
                return -1;
            
            sprinklers_on++;
            target = max_range +1;
            i++;
        }
        
        return sprinklers_on;
    }

}
