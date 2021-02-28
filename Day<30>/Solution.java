import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        }
    }
}// } Driver Code Ends


class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[105][105];
        
        for(int i =0;i<105;i++)
            for(int j = 0 ;j<105;j++)
                dp[i][j] = -1;
                
        return build_bridges_util(0,0,str1,str2,n,m,dp);
    }
    public static int build_bridges_util(int i , int j , String str1 , String str2 , int n , int m , int dp[][])
    {
        if(i>=n || j>=m)
            return 0;

        int ans = dp[i][j];
        if(ans!=-1)
            return ans;
        
        ans = 0;
        if(str1.charAt(i)==str2.charAt(j))
            ans = 1 + build_bridges_util(i+1, j+1 , str1 , str2 , n , m , dp);
        
        ans = Math.max(ans, build_bridges_util(i+1, j , str1 , str2 , n , m , dp));
        ans = Math.max(ans, build_bridges_util(i, j+1 , str1 , str2  , n , m , dp));
        
        dp[i][j] = ans;
        return ans;
    }
}
