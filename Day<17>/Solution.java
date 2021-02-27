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

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
		Stack<Integer> s = new Stack<Integer>(); 
		int result[] = new int[n];
 		Arrays.fill(result, -1); 

		for (int i = 0; i < n; i++) { 

			if (s.empty()) { 
				s.push(i); 
				continue; 
			} 

			while (s.empty() == false && arr[s.peek()] > arr[i]) { 
				result[s.peek()] = arr[i]; 
				s.pop(); 
			} 
			s.push(i); 
		} 
		return result; 
	} 	
}
