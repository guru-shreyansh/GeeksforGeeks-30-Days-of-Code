#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    long long ValidPair(int a[], int n)
    {
    	sort(a, a+n);
    	long long ans = 0;
    	for (int i = 0; i < n; ++i)
		{
	    	if (a[i] <= 0)
    			continue;
    	    // search for first element >= (-a[i] + 1)
    	    int j = lower_bound(a, a + n, -a[i] + 1) - a;
    	    ans += (long long )(i - j);
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
		int array[n];
		for (int i = 0; i < n; ++i)
	    	cin>>array[i];
	 	Solution obj;
	 	cout << obj.ValidPair(array, n) <<"\n";
    }
    return 0; 
}
