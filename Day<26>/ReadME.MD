<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Project Manager</h1>

`DFS`
`Graph`
`Sorting`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C26%3E/D26.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 20</h3>
<blockquote>An IT company is working on a large project. The project is broken into N modules and distributed to different teams. The amount of time (in months) required to complete each module is given in an array duration[ ] i.e. time needed to complete ith module is duration[i] months. 
You are also given M dependencies such that for each i (1 ≤ i ≤ M)  dependencies[i][1]th module can be started after dependencies[i][0]th module is completed.
As the project manager, compute the minimum time required to complete the project.
  <b>Note:</b> It is guaranteed that a module is not dependent on itself.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 6, M = 6<br>
&emsp;&emsp;duration[ ] = {1, 2, 3, 1, 3, 2}<br>
&emsp;&emsp;dependencies:
5 2
5 0
4 0 
4 1
2 3
3 1<br>
&emsp;&emsp;Output: 8<br>
<br>
&emsp;&emsp;Explanation: <img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C26%3E/D26_Exp.png" height="300" width="500">The Graph of dependency forms this and the project will be completed when Module 1 is completed which takes 8 months.<br>

* **Example 2**:<br>
&emsp;&emsp;N = 3, M = 3<br>
&emsp;&emsp;duration[] = {5, 5, 5}<br>
&emsp;&emsp;dependencies:
0 1
1 2
2 0<br>
&emsp;&emsp;Output: -1<br>
&emsp;&emsp;Explanation: There is a cycle in the dependency graph hence the project cannot be completed.<br>

**➔ Your Task**:
<mark>Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. Return -1 if the project can not be completed.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N+M)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` M ` ≤  10⁵<br>
1  ≤ ` duration[i] ` ≤  10⁵

###      ∑ HINTS ▸
- [x] _Use topological sorting. Check for cycle, and use back tracking dfs to calculate the answer._
```java
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
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
