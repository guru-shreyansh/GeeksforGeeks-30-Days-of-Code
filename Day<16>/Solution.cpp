#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution{
    public:
    string Reduced_String(int k,string s){
        if(k == 1){
            string ans = "";
            return ans;
        }
        
        stack<pair<char,int>> st;
        string ans="";
        for(int i=0;i<s.size();i++)
        {
            if(st.empty())
            {
                st.push({s[i],1});
            }
            else if(st.top().first==s[i]){
                st.push({s[i],st.top().second+1});
                if(st.top().second==k){
                    int x=k;
                    while(x){
                        st.pop();
                        x--;
                    }
                }
            }
            else if(st.top().first!=s[i]){
                st.push({s[i],1});
            }
        }
        
        while(!st.empty()){
            ans+=st.top().first;
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
// { Driver Code Starts.

int main() {
    
    
    int t;cin>>t;
    while(t--)
    {
        int k;
        cin>>k;
        string s;
        cin>>s;
        Solution obj;
        cout<<obj.Reduced_String(k,s)<<"\n";
        
    }
    
	return 0;
}
