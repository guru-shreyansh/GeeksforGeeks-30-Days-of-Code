#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    
    return temp;
}

Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));
        
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}


 // } Driver Code Ends


/*
// node structure:

struct Node
{
    int data;
    Node* left;
    Node* right;
};

*/



class Solution{
    
    private:
    void add_subtree(Node* n, int dist, int* sum)
    {
        if( !n || dist<0 ) return;
        *sum += n->data;
        add_subtree(n->left, dist-1, sum);
        add_subtree(n->right, dist-1, sum);
    }
    
    int traverse(Node* n, int target, int k, int* sum)
    {
        if(!n) return -1;
        if(n->data==target)
        {
            add_subtree(n, k, sum);
            // adding all nodes within range in the sub tree below
            return k-1;
        }
        
        int dist = traverse(n->left, target, k, sum);
        if(dist>-1)
        // dist>-1 indicates target was found in left subtree
        {
            *sum += n->data;
            add_subtree(n->right, dist-1, sum);
            // adding values from right sub tree
            return dist-1;
        }
        
        dist = traverse(n->right, target, k, sum);
        if(dist>-1)
        // dist>-1 indicates target was found in right subtree
        {
            *sum += n->data;
            add_subtree(n->left, dist-1, sum);
            // adding values from left sub tree
            return dist-1;
        }
        
        return -1;
    }
    
    public:
    int sum_at_distK(Node* root, int target, int k)
    {
        int sum = 0;
        traverse(root, target, k, &sum);
        return sum;
    }


};


// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    getchar();
    
    while(t--)
    {
        string s;
        getline(cin,s);
        Node* root = buildTree(s);
        
        int target,k;
        cin>> target >> k;
        getchar();
        Solution obj;
        cout<< obj.sum_at_distK(root,target,k) << endl;
    }
	return 0;
}
