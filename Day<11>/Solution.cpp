#include <bits/stdc++.h>
using namespace std;

class Solution
{
    private:
    void fill_array(string s, int a[])
    {
        a[0] = 0;
        for (int i=1 ; i<s.size() ; i++)
        {
            int series = a[i-1];
            while (series)
            {
                if ( s[series] == s[i] )
                {
                    a[i] = series+1;
                    break;
                }
                series = a[series-1];
            }
            if (!series)
                a[i] = ( s[i] == s[0] );
        }
    }
    
    public:
    string compress(string s)
    {
        int a[(int)s.size()];
        // ith element of array a stores the length of longest proper suffix which is also a proper prefix for substr s[0] to s[i]
        fill_array( s, a );
        
        stack <char> shortened;
        
        for (int i=s.size()-1 ; i>0 ; i--)
        // we start checking string from last index
        {
            if (i%2==0) { shortened.push(s[i]); continue; }
            // for even index, string length is odd hence it cannot be divided into two so we simply push ith character in stack
            
            bool star_here=0;
            // star_here will be made TRUE if substring s[0] to s[i] can be divided into identical halves
            int suffix = a[i];
            int substrlen = i+1;
            // suffix and substring length are also meant for substring s[0] to s[i]
            
            if (suffix*2 >= substrlen)
                if ( substrlen % (substrlen-suffix) == 0 )
                    if ( ( substrlen / (substrlen-suffix) ) % 2 == 0 )
                    // these conditions, if true, imply that, substring can be divided into 2 identical halves
                        star_here = 1;
            
            if (star_here)
                shortened.push('*'); i = i/2 + 1;
                // adding * to stack and moving index as required
            else
                shortened.push(s[i]);
                // else, simply adding character to stack
        }
        
        string ret;
        ret.push_back( s[0] );
        
        while( !shortened.empty() )
        {
            // since we analysed input string from end to start removing elements from stack and pushing back to
            // output string will reverse them back to required order
            ret.push_back( shortened.top() );
            shortened.pop();
        }
        return ret;
    }
};

int main()
{
    int t;
    cin>>t;
    while (t--)
    {
        string s;
        cin>>s;
        Solution obj;
        cout<< obj.compress(s) << "\n";
    }
    return 0;
}
