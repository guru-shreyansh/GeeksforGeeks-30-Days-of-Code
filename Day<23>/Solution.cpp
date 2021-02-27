#include <bits/stdc++.h> 
using namespace std; 


 // } Driver Code Ends
//User function Template for C++

class Solution{
    struct Info{
    	int distance;
    	int houseno;
    
    	Info(int x,int y)
    	{
    		distance = x;
    		houseno = y;
    	}
    };
    
    struct Compare{
    	bool operator() (Info const& p1,Info const& p2 )
    	{
    		if (p1.distance == p2.distance)	
    			return p1.houseno < p2.houseno;
    		else
    		    return p1.distance < p2.distance;
    	}
    };
    
    public:
    vector<int> Kclosest(vector<int>arr, int n, int x, int k) 
    { 
    	vector<int> result;
    	priority_queue <Info, vector<Info>, Compare> pq; 
    
    	for (int i = 0; i < k; i++) 
    	{
    		Info obj(abs(arr[i] - x) , arr[i] );
    		pq.push(obj); 
    	}
    
    	for (int i = k; i < n; i++) 
    	{ 
    		int diff = abs(arr[i] - x); 
    		if (diff > pq.top().distance) 
    			continue; 
    		
    		if (diff == pq.top().distance && arr[i] > pq.top().houseno) 
    			continue; 
    		
    		pq.pop();
    		Info obj(abs(arr[i] - x) , arr[i] );
    		pq.push(obj); 
    	} 
    	while (pq.empty() == false) { 
    		result.push_back(pq.top().houseno);
    		pq.pop();
    	}
    	sort(result.begin(),result.end());
    	return result;
    }      
};

// { Driver Code Starts.

int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n,x,k;
		cin>>n>>x>>k; 
		vector <int> array(n);
		for (int i = 0; i < n; ++i)
			cin>>array[i];
        
        Solution obj;
		vector <int> result = obj.Kclosest(array, n, x, k); 
		for (int i = 0; i < result.size(); ++i)
		{
			cout<<result[i]<<" ";
		}
		cout<<"\n";
	}

	return 0; 
}
