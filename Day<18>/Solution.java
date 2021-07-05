import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for (int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if (ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}

class Solution
{
    static boolean recreationalSpot(int[] arr , int n)
    {
        if (n < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] temp = new int[n];
        temp[0] = arr[0];
        for(int i = 1; i <n; i++)
            temp[i] = Math.min(temp[i - 1], arr[i]);
        
        for (int j = n - 1; j >= 0; j--)
        {
            if (arr[j] > temp[j])
            {
                while (!stack.empty() && stack.peek() <= temp[j])
                    stack.pop();
                if (!stack.empty() && stack.peek() < arr[j])
                    return true;
                stack.push(arr[j]);
            }
        }
        return false;
    }
}
