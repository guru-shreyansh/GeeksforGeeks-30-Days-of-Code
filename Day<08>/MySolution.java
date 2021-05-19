import java.io.*;
import java.util.*; 

class Solution
{
    static int maxCandy(int height[], int n)
    {
	if ( n < 3 )    return 0;
	int start = 0;
	int end = n-1;
	int currArea = 0;
	int maxFound = ( n-2 )*( Math.min(height[0] , height[n-1]) );
	    
	while ( start < end )
	{
	    currArea = Math.min(height[start] , height[end]) * (end-start-1);
	    maxFound = Math.max(currArea , maxFound);
	        
	    if ( height[start] < height[end] )
		++start;
	    else 
		--end;
	}
	return maxFound;
    }
}

class GURU
{
    public static void main(String[] args) 
    { 
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	while (t > 0)
	{
            int n = sc.nextInt();
            int height[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                height[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.maxCandy(height,n));
            t--;
        }
    }
}
