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
        return longestCommonSubsequence(str1 , str2);
    }
    public static int longestCommonSubsequence(String S1, String S2)
    {
        char[] C1 = S1.toCharArray();
        char[] C2 = S2.toCharArray();
        
        int[][] _Dp = new int[C1.length + 1][C2.length + 1];
        for (int i=0; i<C1.length; i++)
            for (int j=0; j<C2.length; j++)
                _Dp[i+1][j+1] = C1[i] == C2[j]? _Dp[i][j]+1 : Math.max(_Dp[i][j+1], _Dp[i+1][j]);
                
        return _Dp[C1.length][C2.length];
    }
}
