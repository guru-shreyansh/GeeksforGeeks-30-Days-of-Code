import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}// } Driver Code Ends
class Solution
{
    static boolean recreationalSpot(int[] arr , int n)
    {
        int currMin = arr[0], currMax = arr[0];
        
        for (int i=1; i<n; i++)
        {
            currMin = Math.min(arr[i] , currMin);
            currMax = Math.max(arr[i] , currMax);
            
            if ( arr[i] < currMax && currMin < arr[i] )
                return true;
        }
        return false; 
    }
}
