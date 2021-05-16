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
            int n = sc.nextInt();
            int array[] = new int[n];
            for (int i=0; i<n ;i++ )
	    {
		array[i] = sc.nextInt();
	    }
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    }
}
class Solution
{
    static long ValidPair(int arr[], int n)
    {
	boolean allPositive = true, allNonPositive = true; int i=0;
	for (i=0; i<n; i++) if (arr[i] < 1) allPositive = false;
	for (i=0; i<n; i++) if (0 < arr[i]) allNonPositive = false;
	if (allPositive)    return (long)n*((long)n-1L)/2L;  // If all elements are +ve (>=1)
	if (allNonPositive) return 0;			     // If all elements are -ve or 0 (<=0)
	
	Arrays.sort(arr);
	int j=0, key=0, end=n-1;
	long validPairs = 0L;
	    
	for (i=1; i<n; i++)
	{
	    if (arr[i] <= 0)
	        continue;
	    j=0;
	    key = -arr[i];
	    j = FirstElementStrictlyGreaterThanTheKey(arr,key,0,end);
	        
	    end = j;                       // Storing the position of found key
	    validPairs += (long)(i-j);          // to optimize the code
	}
	return validPairs;
    }
    static int FirstElementStrictlyGreaterThanTheKey(int[] arr, int key, int start, int end)
    {
        int pos = -1;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (arr[mid] <= key)
                start = mid + 1;
            else
            {
                pos = mid;
                end = mid - 1;
            }
        }
        return pos;
    }
}
