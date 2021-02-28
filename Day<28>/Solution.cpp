#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int min_sprinklers(int gallery[], int n)
    {
        vector<pair<int,int>> sprinklers;
        for(int i=0; i<n; i++)
            if(gallery[i] > -1)
                sprinklers.push_back( pair<int,int> ( i-gallery[i], i+gallery[i] ) );
        
        sort(sprinklers.begin(), sprinklers.end());
        
        int target=0, sprinklers_on=0, i=0;
        while(target<n)
        {
            if(i==sprinklers.size() || sprinklers[i].first>target)
                return -1;
            
            int max_range = sprinklers[i].second;
            while( i+1<sprinklers.size() && sprinklers[i+1].first<=target )
            {
                i++;
                max_range = max( max_range,  sprinklers[i].second );
            }
            if(max_range<target)
                return -1;
            
            sprinklers_on++;
            target = max_range +1;
            i++;
        }
        
        return sprinklers_on;
    }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        
        int gallery[n];
        for(int i=0; i<n; i++)
            cin>> gallery[i];
        Solution obj;
        cout<< obj.min_sprinklers(gallery,n) << endl;
    }
	return 1;
}
