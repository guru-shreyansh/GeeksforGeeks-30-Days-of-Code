#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends

class Solution{
    
    public:
    int maxCandy(int height[], int n) 
    { 
    
    	// To store the maximum water so far 
    	int maximum = 0; 
    
    	// Both the pointers are pointing at the first 
    	// and the last buildings respectively 
    	int i = 0, j = n - 1; 
    
    	// While the water can be stored between 
    	// the currently chosen buildings 
    	while (i < j) 
    	{ 
    
    		// Update maximum water so far and increment i 
    		if (height[i] < height[j]) 
    		{ 
    			maximum = max(maximum, (j - i - 1) * height[i]); 
    			i++; 
    		} 
    
    		// Update maximum water so far and decrement j 
    		else if (height[j] < height[i]) 
    		{ 
    			maximum = max(maximum, (j - i - 1) * height[j]); 
    			j--; 
    		} 
    
    		// Any of the pointers can be updated (or both) 
    		else
    		{ 
    			maximum = max(maximum, (j - i - 1) * height[i]); 
    			i++; 
    			j--; 
    		} 
    	} 
    
    	return maximum; 
    }   
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--)
    {
    	int n;
    	cin>>n;
    	int height[n];
    	for (int i = 0; i < n; ++i)
    	{
    		cin>>height[i];
    	}
    	
    	Solution obj;
    	
    	cout << obj.maxCandy(height,n)<<"\n";
    }
    return 0;
}
