import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        int ans[][] = new int[m][n];
        Queue <Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 'B')
                {
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
                else 
                    ans[i][j] = -1;
            }
        }
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair p = q.peek();
                int i = p.x;
                int j = p.y;
                q.remove();
                
                if(i + 1 < m && mat[i+1][j] == 'O' && ans[i+1][j] == -1)
                {
                    ans[i+1][j] = 1+ ans[i][j];
                    q.add(new Pair(i+1,j));
                }
                
                if(i - 1 >= 0 && ans[i-1][j] == -1 && mat[i-1][j] == 'O')
                {
                    ans[i-1][j] = 1 + ans[i][j];
                    q.add(new Pair(i-1,j));
                }
                
                if(j + 1 < n && ans[i][j + 1] == -1 && mat[i][j + 1] == 'O')
                {
                    ans[i][j + 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j + 1));
                }
                
                if(j - 1 >= 0 && mat[i][j - 1] == 'O' && ans[i][j-1] == -1)
                {
                    ans[i][j - 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j - 1));
                }
            }
        }
        
        return ans;
    }
}
