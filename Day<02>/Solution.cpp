#include<bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    // function to change 'N' from base10 to base9
    long long findNth(long long N)
    {
        long long base10num = N;
        long long base9num = 0;
        long long pos = 1;
        while ( base10num>0 )
        {
            // taking remainder with 9
            base9num += pos * (base10num%9);
            // dividing number with 9
            base10num /= 9;
            // multiplying position with 10
            pos *= 10;
        }
        return base9num; 
    }
};

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		long long n , ans;
		cin >> n;
		Solution obj;
		ans = obj.findNth(n);
		cout << ans << endl;
	}
}
