#include <bits/stdc++.h>
using namespace std;
#define endl '\n'


 // } Driver Code Ends

class Solution{
    public:
    int minTime(vector<pair<int, int>> &dependency, int duration[], int n, int m) {
        vector<int> v[n+1];
        int vis[n+1]={0},deg[n+1]={0},req[n+1]={0},ans=0;
        for(auto i:dependency)
        {
            v[i.first].push_back(i.second);
            deg[i.second]++;
        }
        vector<int> q;
        for(int i=0;i<n;i++)
        {
            if(deg[i]==0)
            {
                vis[i]=1;
                q.push_back(i);
            }
            req[i]=duration[i];
            ans=max(ans,req[i]);
        }
        while(q.size())
        {
            int node=q.back();
            q.pop_back();
            for(auto i:v[node])
            {
                deg[i]--;
                req[i]=max(req[node]+duration[i],req[i]);
                if(deg[i]==0){
                q.push_back(i);
                vis[i]=1;
                ans=max(ans,req[i]);
                }
            }
        }
        for(int i=0;i<n;i++)
        if(vis[i]==0)
        return -1;
        return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m, x, y;
        cin >> n >> m;
        int duration[n + 5];
        vector<pair<int, int>> dependency;
        for (int i = 0; i < n; i++) cin >> duration[i];
        for (int i = 0; i < m; i++) {
            cin >> x >> y;
            dependency.push_back({x, y});
        }
        Solution obj;
        cout << obj.minTime(dependency, duration, n, m) << endl;
    }
    return 0;
}
