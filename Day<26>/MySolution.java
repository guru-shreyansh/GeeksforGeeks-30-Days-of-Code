import java.io.*;
import java.util.*;

class pair
{
    int x, y;
    pair()
    {
        this.x = 0;
        this.y = 0;
    }
    pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class GURU
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0)
        {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] dr = br.readLine().trim().split(" ");
            int[] duration = new int[dr.length];
            for (int i = 0; i < dr.length; i++)
            {
                duration[i] = Integer.parseInt(dr[i]);
            }
            ArrayList<pair> dependency = new ArrayList<>();
            for (int i = 0; i < m; i++)
            {
                String[] xy = br.readLine().trim().split(" ");
                dependency.add(new pair(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
            }
            Solution sln = new Solution();
            System.out.println(sln.minTime(dependency, duration, n, m));
        }
    }
}

class Solution
{
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        int[] independent = new int[n];
        for (int i = 0; i < m; i++)
        {
            adj.get(dependency.get(i).x).add(dependency.get(i).y);
            independent[dependency.get(i).y]++;
        }
        int flag = 0;
        for (int i = 0; i < n; i++)
            if (independent[i] == 0)
                flag = 1;
        if (flag == 0)
            return -1;
        cycleHelper cyHlp = new cycleHelper(n);
        for (int i = 0; i < n; i++)
        {
            if (independent[i] != 0)
                continue;
            cyHlp.visited[i] = true;
            if (checkCycle(i, adj, cyHlp)) return -1;
        }
        int[] reqTime = new int[n];
        Arrays.fill(reqTime, -1);
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (independent[i] == 0)
                ans = Math.max(ans, dfs(i, adj, duration, reqTime));

        return ans;
    }
    public boolean checkCycle(int nd, ArrayList<ArrayList<Integer>> adj, cycleHelper cyHlp)
    {
        cyHlp.isStack[nd] = true;
        for (int it : adj.get(nd))
        {
            if (cyHlp.visited[it] == true)
            {
                if (cyHlp.isStack[it] == true) return true;
                continue;
            }
            cyHlp.visited[it] = true;
            if (checkCycle(it, adj, cyHlp)) return true;
        }
        cyHlp.isStack[nd] = false;
        return false;
    }
    public int dfs(int nd, ArrayList<ArrayList<Integer>> adj, int[] duration, int[] reqTime)
    {
        if (reqTime[nd] != -1) return reqTime[nd];
        int maxi = 0;
        for (int it : adj.get(nd))
            maxi = Math.max(maxi, dfs(it, adj, duration, reqTime));
        reqTime[nd] = maxi + duration[nd];
        return reqTime[nd];
    }
    class cycleHelper
    {
        boolean[] visited;
        boolean[] isStack;
        cycleHelper(int n)
        {
            this.visited = new boolean[n];
            this.isStack = new boolean[n];
        }
    }
}
