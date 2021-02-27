#include <bits/stdc++.h> 
using namespace std; 

//Back-end complete function Template for C++

class Solution{
    
    private:
    int digitSum(int n) 
    { 
    	int sum = 0; 
    	while (n) { 
    		sum += (n % 10); 
    		n /= 10; 
    	} 
    	return sum; 
    } 
    
    public:
    int RulingPair(vector<int> arr, int n) 
    { 
    	unordered_map<int, int> mp; 
    	int ans = -1; 
    
    	for (int i = 0; i < n; i++) { 
    		int dSum = digitSum(arr[i]); 
    
    		if (mp[dSum] != 0) { 
    			ans = max(ans, mp[dSum] + arr[i]); 
    		} 
    		mp[dSum] = max(mp[dSum], arr[i]); 
    	} 
    	return ans; 
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
		vector<int> arr(n);
		for (int i = 0; i < n; ++i)
			cin>>arr[i];
	    Solution obj;
		cout << obj.RulingPair(arr,n)<<"\n";
	}
	return 0; 
}
