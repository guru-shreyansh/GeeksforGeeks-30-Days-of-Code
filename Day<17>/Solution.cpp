#include <bits/stdc++.h> 
using namespace std; 


 // } Driver Code Ends
//User function Template for C++

class Solution{
    
    public:
    vector<int> help_classmate(vector<int> arr, int n) 
    { 
    	stack<int> s; 
    	vector<int> result(n,-1);
    	
    	for (int i = 0; i < n; i++) { 
    		if (s.empty()) { 
    			s.push(i); 
    			continue; 
    		} 
    		while (s.empty() == false && arr[s.top()] > arr[i]) { 
    			result[s.top()] = arr[i];
    			s.pop(); 
    		} 
    		s.push(i); 
    	} 
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
		int n;
		cin>>n;
		vector<int> array(n);
		for (int i = 0; i < n; ++i)
		{
			cin>>array[i];
		}
		Solution obj;
		vector<int> result = obj.help_classmate(array,n);
		for (int i = 0; i < n; ++i)
		{
			cout<<result[i]<<" ";
		}
		cout<<"\n";
	}
	return 0; 
}
