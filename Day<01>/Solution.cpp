#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    void prank(long long a[], int n)
    {
        long long N = n;
        for (int i=0; i<n; i++)
        {
            a[i] = a[i] + ( a[a[i]] % N ) * N;
        }

        for (int i=0; i<n; i++)
            a[i] = a[i] / N;
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
        long long a[n];
        for (int i=0; i<n; i++)
            cin >> a[i];
        Solution ob;
        ob.prank(a,n);

        for (int i=0; i<n; i++)
            cout << a[i] << " ";
        cout << "\n";
    }
}
