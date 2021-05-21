#include <bits/stdc++.h>
using namespace std;

class Solution
{
    private:
    bool isSubString(string s, string sub)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == sub[count])
                count++;
            else
                i-=count;
                count = 0;
            if (count == sub.length())
                return true;
        }
        return false;
    }

    public:
    int repeatedStringMatch(string A, string B)
    {
        string temp = A;
        int count = ceil(float(B.length()) / float(A.length()));

        for (int i=1; i<count; i++)
            A += temp;

        if (isSubString(A,B))
            return count;
        else
        {
            A += A;
            if (isSubString(A,B))
                return count+1;
        }
        return -1;
    }
};

int main()
{
    int t;
    cin>>t;
    while (t--)
    {
        string A,B;
        cin>>A;
        cin>>B;
        Solution obj;
        cout<<obj.repeatedStringMatch(A,B)<<"\n";
    }
    return 0;
}
