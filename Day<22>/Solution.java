import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution sln = new Solution();
            Range rng = sln.shortestRange(root);
            System.out.println(rng.x + " " + rng.y);
        }
    }
}

class Range {
    int x, y;
    Range() {
        this.x = 0;
        this.y = 0;
    }
    Range(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// } Driver Code Ends
class Solution
{
    public Range shortestRange(Node root) {
        // inOrder: stores inorder traversal of the bst
        // level: stores level of ith node in inorder traversal
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        storeInOrder(root, 0, inOrder, level);
        /*
            cntZero: counts number of zeros
            i: left pointer (initially at 0)
            j: right pointer
            k: index of root in inorder traversal
            maxDepth: maximum depth of bst
            Note: these pointers are on the inorder traversal of the tree
        */
        int i = 0, j = 0, k = 0, cntZero = 0,
            maxDepth = Collections.max(level) + 1;
        // stores number of nodes at ith level
        int[] depth = new int[maxDepth];
        // first count number of nodes at ith level till the root
        // right pointer initially is at root's index in inorder traversal of
        // bst
        for (k = 0; k < level.size(); k++) {
            depth[level.get(k)]++;
            if (level.get(k) == 0) {
                j = k;
                break;
            }
        }
        // count number of levels where there are 0 nodes in the range
        // inorder[i] to inorder[j]
        for (int u : depth) {
            if (u == 0) {
                cntZero++;
            }
        }
        // intially shortest range is [x, y]
        // x=node at 0th index
        // y=node at last index
        // i.e. the whole tree
        int x = inOrder.get(0), y = inOrder.get(inOrder.size() - 1);
        // if currently picked range contains all levels change x and y
        // accordingly
        if (cntZero == 0) {
            x = inOrder.get(i);
            y = inOrder.get(j);
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
                    if ((y - x) > (inOrder.get(j) - inOrder.get(i))) {
                        x = inOrder.get(i);
                        y = inOrder.get(j);
                    }
                    break;
                }
                j++;
                if (j >= inOrder.size()) {
                    break;
                }
                // if new level is discovered by this range then cntZero is
                // decreased by 1
                if (depth[level.get(j)] == 0) {
                    cntZero--;
                }
                depth[level.get(j)]++;
            }
            // while current range contains all levels
            // we can shift the left pointer by +1
            while (cntZero == 0 && i <= k) {
                if ((y - x) > (inOrder.get(j) - inOrder.get(i))) {
                    x = inOrder.get(i);
                    y = inOrder.get(j);
                }
                depth[level.get(i)]--;
                // if this level is outside the current range then cntZero is
                // increased by 1
                if (depth[level.get(i)] == 0) {
                    cntZero++;
                }
                i++;
            }
        }
        return new Range(x, y);
    }

    /*
        root: current node
        depth: depth of current node
        inOrder: inorder traversal of tree
        level: stores levels of the nodes
    */
    public void storeInOrder(Node root, int depth, ArrayList<Integer> inOrder,
                      ArrayList<Integer> level) {
        if (root == null) return;
        // recur for left subtree
        storeInOrder(root.left, depth + 1, inOrder, level);
        // store inorder
        inOrder.add(root.data);
        // store depth of that node
        level.add(depth);
        storeInOrder(root.right, depth + 1, inOrder, level);
    }
}
