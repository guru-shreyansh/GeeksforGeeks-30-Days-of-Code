#include <bits/stdc++.h>
using namespace std;

class Solution
{
    private:
    int digitSum(int n)
    {
    	int sum = 0;
    	while (n)
	    {
    		sum += (n % 10);
    		n /= 10;
    	}
    	return sum;
    }
    
    public:
    int RulingPair(vector<int> arr, int n)
    {
    	unordered_map<int, int> map;
    	int ans = -1;

    	for (int i = 0; i < n; i++)
		{
    		int dSum = digitSum(arr[i]);
    		if (map[dSum] != 0)
			{
    			ans = max(ans, map[dSum] + arr[i]);
    		}
    		mp[dSum] = max(map[dSum], arr[i]);
    	}
    	return ans;
    }
};

int main()
{
	int t;
	cin>>t;
	while (t--)
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
