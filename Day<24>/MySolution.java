import java.io.*;
import java.util.*;

class GURU
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
        Map<Integer, Integer> fMap = new HashMap<>();
        for (Integer num : array)
        {
            fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        }
        
        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b)
        -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
                                             : Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<Integer,Integer> key : fMap.entrySet())
        {
            heap.offer( key );
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<k; i++)
        {
            ans.add( heap.poll().getKey() );
        }
        return ans;
    }
}
