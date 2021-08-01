#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    int catchThieves(char arr[], int n, int k)
    {
    	int result = 0;
    	vector<int> thief;
    	vector<int> police;

    	for (int i = 0; i < n; i++)
		{
    		if (arr[i] == 'P')
    			police.push_back(i);
    		else if (arr[i] == 'T')
    			thief.push_back(i);
    	}
    
    	// track lowest current indices of thief: thi[l], police: pol[r]
    	int l = 0, r = 0;
    	while (l < thief.size() && r < police.size())
		{
    		// can be caught
    		if (abs(thief[l] - police[r]) <= k)
			{
    			result++;
    			l++;
    			r++;
    		}
    		// increment the minimum index
    		else if (thief[l] < police[r])
    			l++;
    		else
    			r++;
    	}
    	return result;
    }
};

int main()
{
	int t;
	cin>>t;
	while (t--)
	{
		int n, k;
		cin>>n >> k;
		char arr[n];
		for (int i = 0; i < n; ++i)
			cin>>arr[i];
		Solution obj;
		cout<<obj.catchThieves(arr, n, k) << endl;
	}
	return 0;
}
