#include <bits/stdc++.h>
using namespace std;

int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   	int t;
   	cin >> t;
   	while (t--)
   	{
   		string str;
   		cin >> str;
   		Solution obj;
   		cout << obj.maxFrequency(str) << "\n";
   	}
    return 0;
}

class Solution
{
    public:
    vector<int> z_function(string s)
    {
    	int n = s.size();
    	vector<int> z(n);
    	for (int i = 1, l = 0, r = 0; i < n; i++)
    	{
    		if (i <= r)
    			z[i] = min(r - i + 1, z[i - l]);
    		
    		while (i + z[i] < n && s[z[i]] == s[i + z[i]])
    			z[i]++;
    		
    		if (r < i + z[i] - 1)
    			l = i, r = i + z[i] - 1;
    	}
    	return z;
    }
    
    void update(int idx, int val, vector<int> &bit, int n)
    {
    	if (idx == 0)
    		return;
    	while (idx <= n)
    	{
    		bit[idx] += val;
    		idx += (idx&-idx);
    	}
    }
    
    int pref(int idx, vector<int> &bit)
    {
    	int ans = 0;
    	while (0 < idx)
    	{
    		ans += bit[idx];
    		idx -= (idx&-idx);
		}
    	return ans;
    }
    
    int maxFrequency(string str)
    {
    	int n = str.size();
    	vector<int> z = z_function(str);
    	vector<int> bit(n+5, 0);
		
    	for (int i = 1; i < n; i++)
    		update(z[i], 1, bit, n);
		
    	map<int, int> m;
    	for (int i = n-1; 1 <= i; i--)
    	{
    		if (z[i] != (n-i))
    			continue;
    		m[z[i]] += (pref(n, bit) - pref(z[i]-1, bit) + 1);
    	}
    	int ans = 1;
    	for (auto it:m)
    		ans = max(ans, it.second);
    	return ans;
    }
};
