import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (int i=0; i<n; i++)
            {
                int x = sc.nextInt();
                arr.add(x);
            }
            int k = sc.nextInt();
            
            Solution obj = new Solution();
            res = obj.TopK(arr,k);
            
            for (int i=0; i<res.size(); i++)
            {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}

class Solution
{
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        int i,j=0;
        int arr[] = new int[10002];
        for (i=0; i<10002; i++)
            arr[i] = 0;
            
        for (i=0; i<array.size(); i++)
            arr[array.get(i)]++;
        
        ArrayList<Integer>res[] = new ArrayList[100002];
        for (i=0; i<100002; i++)
        {
            ArrayList<Integer>temp = new ArrayList<Integer>();
            res[i]=temp;
        }
        for (i=0; i<10002; i++)
            if (arr[i]!=0)
                res[arr[i]].add(i);

        ArrayList<Integer>ans = new ArrayList<Integer>();
        for (i=100001; 0<=i; i--)
        {
            for (int p=res[i].size()-1; 0<=p; p--)
            {
                if (j!=k)
                    ans.add(res[i].get(p));
                else
                    break;
                j++;
            }
        }
        return ans;
    }
}
