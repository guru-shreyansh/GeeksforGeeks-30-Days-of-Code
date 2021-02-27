#include <bits/stdc++.h>

using namespace std;

// Tree Node
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

// Function to Build Tree
Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

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
        if (i >= ip.size()) break;
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
// User function Template for C++

/*
    root: current node
    depth: depth of current node
    inOrder: inorder traversal of tree
    level: stores levels of the nodes
*/

class Solution{
    
    private:
    void storeInOrder(Node *root, int depth, vector<int> &inOrder,
                  vector<int> &level) {
        if (!root) return;
        // recur for left subtree
        storeInOrder(root->left, depth + 1, inOrder, level);
        // store inorder
        inOrder.push_back(root->data);
        // store depth of that node
        level.push_back(depth);
        // recur for right subtree
        storeInOrder(root->right, depth + 1, inOrder, level);
    }
    
    public:
    pair<int, int> shortestRange(Node *root) {
        // inOrder: stores inorder traversal of the bst
        // level: stores level of ith node in inorder traversal
        vector<int> inOrder, level;
        storeInOrder(root, 0, inOrder, level);
        //        for (int u: inOrder) {
        //            cout << u << " ";
        //        }
        //        cout << "\n";
        //        for (int u: level) {
        //            cout << u << " ";
        //        }
        //        cout << "\n";
        /*
            cntZero: counts number of zeros
            i: left pointer (initially at 0)
            j: right pointer
            k: index of root in inorder traversal
            maxDepth: maximum depth of bst
            Note: these pointers are on the inorder traversal of the tree
        */
        int i = 0, j = 0, k = 0, cntZero = 0,
            maxDepth = *max_element(level.begin(), level.end()) + 1;
        // stores number of nodes at ith level
        vector<int> depth(maxDepth, 0);
        // first count number of nodes at ith level till the root
        // right pointer initially is at root's index in inorder traversal of bst
        for (k = 0; k < level.size(); k++) {
            depth[level[k]]++;
            if (level[k] == 0) {
                j = k;
                break;
            }
        }
        // count number of levels where there are 0 nodes in the range inorder[i] to
        // inorder[j]
        for (int u : depth) {
            if (u == 0) {
                cntZero++;
            }
        }
        // intially shortest range is [x, y]
        // x=node at 0th index
        // y=node at last index
        // i.e. the whole tree
        int x = *inOrder.begin(), y = inOrder.back();
        // if currently picked range contains all levels change x and y accordingly
        if (cntZero == 0) {
            x = inOrder[i], y = inOrder[j];
        }
        // left pointer can at most go upto root's index(i.e. k)
        // right pointer can go upto last index of inorder traversal of tree
        while (i <= k && j < inOrder.size()) {
            // while right pointer doesn't reach last index
            // and the current range doesn't contain all levels
            while (j < inOrder.size()) {
                // if cntZero is 0 then this range contains all levels
                if (cntZero == 0) {
                    // if previous range is large then change the range
                    if ((y - x) > (inOrder[j] - inOrder[i])) {
                        x = inOrder[i];
                        y = inOrder[j];
                    }
                    break;
                }
                // increase right pointer
                j++;
                if (j >= inOrder.size()) {
                    break;
                }
                // if new level is discovered by this range then cntZero is
                // decreased by 1
                if (depth[level[j]] == 0) {
                    cntZero--;
                }
                // increase count of nodes at that level
                depth[level[j]]++;
            }
            // while current range contains all levels
            // we can shift the left pointer by +1
            while (!cntZero && i <= k) {
                // if previous range is large then change the range
                if ((y - x) > (inOrder[j] - inOrder[i])) {
                    x = inOrder[i];
                    y = inOrder[j];
                }
                // decrease count of nodes at that level
                depth[level[i]]--;
                // if this level is outside the current range then cntZero is
                // increased by 1
                if (depth[level[i]] == 0) {
                    cntZero++;
                }
                // shift left pointer
                i++;
            }
        }
        // return the shortest range
        return {x, y};
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    scanf("%d ", &tc);
    while (tc--) {
        string treeString;
        getline(cin, treeString);
        Node *root = buildTree(treeString);
        Solution obj;
        pair<int, int> range = obj.shortestRange(root);
        cout << range.first << " " << range.second << "\n";
    }

    return 0;
}
