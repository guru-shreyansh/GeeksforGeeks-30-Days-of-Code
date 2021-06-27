import java.io.*;
import java.util.*; 
class GURU
{
    public static void main(String args[]) throws IOException
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (0 < t)
	    {
            int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ; i++)
        	    array[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.RulingPair(array,n));
            t--;
        }
    } 
} 

class Solution
{
	static int RulingPair(int arr[], int n)
	{
	    int[] map = new int[76];          // Map with indexes as possible digit sum
	    int maxPair = -1;
	    int value = 0;
	    for (int temp : arr)
	    {
	        int sumOfDigits = digitSum(temp);   // Calculating sum of digits
	        if (0 < map[sumOfDigits])             // If a value with same digit sum
	        {                                       // is already present 
	            value = map[sumOfDigits];
	            maxPair = Math.max(maxPair, value+temp);
	            if (value < temp)                       // Replacing the element if current value
	                map[sumOfDigits] = temp;              // is greater than the previous value
	        }
	        else 
	            map[sumOfDigits] = temp;
	    }
	    return maxPair;
	}
	static int digitSum(int n)
	{
	    int sum = 0;
	    while (0 < n)
	    {
	        sum += (n % 10);
	        n /= 10;
	    }
	    return sum;
    }
}
