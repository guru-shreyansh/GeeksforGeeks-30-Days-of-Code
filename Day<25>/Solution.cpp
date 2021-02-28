#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution{
    
    struct QueueNode 
    { 
        int i, j, distance; 
    };


    private:
    bool isValid(int i, int j, int M, int N) 
    { 
        if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1)) 
            return false; 

        return true; 
    } 

    bool isSafe(int i, int j, vector<vector<char> >& matrix, vector<vector<int> >& result) 
    { 
        if (matrix[i][j] != 'O' || result[i][j] != -1) 
            return false; 

        return true; 
    } 

    public:
    vector<vector<int> > findDistance(vector<vector<char> >& matrix, int M, int N) 
    { 
        vector<vector<int> > result(M);
        queue<QueueNode> q; 

        for (int i = 0; i < M; i++) 
        { 
            result[i].resize(N, -1);
            for (int j = 0; j < N; j++) 
            { 
                if (matrix[i][j] == 'B') 
                { 
                    QueueNode node = {i, j, 0}; 
                    q.push(node); 
                    result[i][j] = 0; 
                } 
            } 
        } 

        while (!q.empty()) 
        { 
            QueueNode curr = q.front(); 
            int x = curr.i, y = curr.j, dist = curr.distance; 

            int row[] = { -1, 0, 1, 0}; 
            int col[] = { 0, 1, 0, -1 }; 

            for (int i = 0; i < 4; i++) 
            { 
                if (isValid(x + row[i], y + col[i], M, N)
                    &&
                    isSafe(x + row[i], y + col[i], matrix, result) 
                    ) 
                { 
                    result[x + row[i]][y + col[i]] = dist + 1; 

                    QueueNode node = {x + row[i], y + col[i], dist + 1}; 
                    q.push(node); 
                } 
            } 

            q.pop(); 
        } 
        return result;
    } 
};

// { Driver Code Starts.


int main()
{

    int t;
    cin >> t;
    while(t--)
    {
    	int M,N;
        cin>>M;
        cin>>N;

        vector<vector<char> > matrix(M);
        for(int i=0; i<M; ++i)
        {
            matrix[i].resize(N);
            for (int j = 0; j < N; ++j)
                cin>>matrix[i][j];
        }

        vector<vector<int> >result;
        Solution obj;
        result = obj.findDistance(matrix, M,N); 
        for(int i=0; i<M; ++i)
        {
            for (int j = 0; j < N; ++j)
                cout<<result[i][j]<<" ";
            cout<<"\n";
        }
    }

    return 0;
}
