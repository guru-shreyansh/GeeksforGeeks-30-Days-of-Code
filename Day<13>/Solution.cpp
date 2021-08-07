#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    bool checktree(int preorder[], int inorder[], int postorder[], int N)
    {
    	// if the array lengths are 0 then all of them are obviously equal
    	if (N == 0) return 1;

    	// if array lengths are 1, then check if all of them are equal
    	if (N == 1)
    	    return (preorder[0] == inorder[0]) && (inorder[0] == postorder[0]);

    	// search for first element of preorder in inorder array
    	int idx = -1;
    	for (int i = 0; i < N; ++i)
    	    if (inorder[i] == preorder[0])
	    	{
    			idx = i;
    			break;
    	    }

    	if (idx == -1) return 0;
    	
    	// matching element in postorder array
    	if( preorder[0] != postorder[N-1] ) return false;

    	// check for the left subtree
    	int ret1 = checktree(preorder + 1, inorder, postorder, idx);

    	// check for the right subtree
    	int ret2 = checktree(preorder + idx + 1, inorder + idx + 1, postorder + idx, N - idx - 1);

    	// return 1 only if both of them are correct else 0
    	return (ret1 && ret2);
    }
};

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
		int n;
		cin>>n;
		int preorder[n];
		int inorder[n];
		int postorder[n];

		for (int i = 0; i < n; ++i)
	    	cin>>preorder[i];

		for (int i = 0; i < n; ++i)
	    	cin>>inorder[i];

		for (int i = 0; i < n; ++i)
	    	cin>>postorder[i];
        
        Solution obj;
		if (obj.checktree(preorder, inorder, postorder, n))
	    	cout << "Yes\n";
		else
	    	cout<<"No\n";
    } 
    return 0; 
}
