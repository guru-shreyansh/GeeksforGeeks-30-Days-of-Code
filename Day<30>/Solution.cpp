#include<bits/stdc++.h>
using namespace std; 


 // } Driver Code Ends
class Solution
{
    public:
    int build_bridges_util(int i , int j , string str1 , string str2 , int n , int m , int dp[105][105])
    {
        if(i>=n or j>=m)
            return 0;
        
        int ans = dp[i][j];
        if(ans!=-1)
            return ans;
        
        ans = 0;
        if(str1[i]==str2[j])
            ans = 1 + build_bridges_util(i+1, j+1, str1, str2,n, m, dp);
        
        ans = max(ans, build_bridges_util(i+1, j, str1, str2, n, m, dp));
        ans = max(ans, build_bridges_util(i, j+1, str1, str2, n, m, dp));
        
        return dp[i][j] = ans;
    }
    
    int build_bridges(string str1, string str2)
    {
        int dp[105][105];
        memset(dp, -1, sizeof dp);
        int n = str1.size();
        int m = str2.size();
        return build_bridges_util(0,0,str1,str2,n,m,dp);
    }
};

// { Driver Code Starts.
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;

    while(t--)
    {
        string str1,str2;
        cin >> str1 >> str2;
        Solution obj;
        cout<<obj.build_bridges(str1,str2)<<endl;
    } 
    return 0;
}
