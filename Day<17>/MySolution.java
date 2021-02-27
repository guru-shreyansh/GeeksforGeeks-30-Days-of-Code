import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 

// } Driver Code Ends

class Solution
{
	public static int[] help_classmate(int arr[], int n) 
	{
	    int j=1;
	    int[] help = new int[n];
	    for (int i=0; i<n; i++)
	    {
	        j = i+1;
	        while (j<n && arr[i] <= arr[j])
	            ++j;
	        if (j != n)
	            help[i] = arr[j];
	        else 
	            help[i] = -1;
	    }
	    return help;
	} 
}
