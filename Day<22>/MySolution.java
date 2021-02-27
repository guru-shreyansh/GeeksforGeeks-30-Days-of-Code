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
    public static List<List<Integer>> levelOrderTraversal(Node root)
    {                                               // List to Store all Nodes at each Level
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LOT(result, root, 0);
        return result;
    }
    public static void LOT(List<List<Integer>> result, Node root, int height)
    {   // Level Order Traversal of BST
        if (root == null)
            return;
        if (height >= result.size())
            result.add(new ArrayList<Integer>());
        result.get(height).add(root.data);
        LOT(result, root.left, height+1);
        LOT(result, root.right, height+1);
    }
    public static Range shortestRange(Node root)
    {                                                   // Finding shortest range for all levels
        if ( root == null )
            return new Range(0,0);
        List<List<Integer>> result = levelOrderTraversal(root);
        
        int n = result.size(), k = 0;
        for (int i=0; i<result.size(); i++) k = Math.max(k , result.get(i).size());
        for (int i=0; i<result.size(); i++)                 // Making size of Arraylist uniform
            for (int j=result.get(i).size(); j<k; j++)
                result.get(i).add(j,result.get(i).get(result.get(i).size()-1));
        
        int L = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	    int range = Integer.MAX_VALUE, R = Integer.MAX_VALUE;
	    PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
	    for(int i=0; i<n; i++)
	    {
	        pq.add( new Triplet(result.get(i).get(0),i,0) );
	        max = Math.max(max , result.get(i).get(0));
	    }
	    while( true )
	    {
	        Triplet t = pq.poll();
	        if ( (max-t.key+1)<range )
	        {
	            range = max-t.key+1;
	            L = t.key;
	            R = max;
	        }
	        if ( t.index==k-1 )
	            break;
	        else 
	        {
	            pq.add(new Triplet(result.get(t.pos).get(t.index+1), t.pos, t.index+1));
	            max = Math.max(max , result.get(t.pos).get(t.index+1));
	        }
	    }
        return new Range(L,R);
    }
}
class Triplet implements Comparable<Triplet>
{
    int key, pos, index;
    Triplet (int key, int pos,int index)
    {
        this.key = key; this.pos = pos; this.index = index;
    }
    public int compareTo(Triplet tri)
    {
        return this.key - tri.key;
    }
}
