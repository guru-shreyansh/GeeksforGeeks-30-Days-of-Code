#include <bits/stdc++.h>
using namespace std;

struct Node 
{
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

// Function to Build Tree
Node *buildTree(string str) 
{
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}

 // } Driver Code Ends
//User function Template for C++

/*
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
*/
class Solution
{
    int ans;

    int post(Node* node)
    {
        bool zero = false , two = false;
        if(node->left==NULL && node->right==NULL)
            return 0;
        
        if(node->left)
        {
            int get = post(node->left);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
        }
        
        if(node->right)
        {
            int get = post(node->right);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
        }
        
        if(zero==true)
        {
            ans++;
            return 2;
        }
        
        if(two==true)
        {
            return 1;
        }
        return 0; 
    }
public:
    int supplyVaccine(Node* root)
    {
        ans = 0;    
        int result = post(root);
        if(result == 0)
            return (ans + 1);
        return ans;
    }
};
