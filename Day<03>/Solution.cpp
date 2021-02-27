#include<bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    long long smallestpositive(vector<long long> array, int n)
    {
        sort(array.begin(),array.end());
        long long result = 1;
        for (int i = 0; i < n && array[i] <= result; i++)
            result = result + array[i];
        return result;
    }
};

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<long long> array(n);
        for (int i=0; i<n; ++i)
        {
            cin >> array[i];
        }
        Solution ob;
        cout << ob.smallestpositive(array,n) << "\n";
    }
    return 0;
}
