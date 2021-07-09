import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GURU
{
    static Node buildTree(String str)
    {
        if (str.length()==0 || str.charAt(0)=='N')
            return null;
        
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (0 < queue.size() && i < ip.length)
        {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N"))
            {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (ip.length <= i)
                break;
            currVal = ip[i];
            
            if (!currVal.equals("N"))
            {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while (t > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution g = new Solution();
            System.out.println(g.supplyVaccine(root));
            t--;
        }
    }
}

class Solution
{
    public static int supplyVaccine(Node root)
    {
        result = 0;
        int out = (out = 0) + traverse(root);
        return (out!=0 ? result : ++result);
    }
    static int result;
    public static int traverse(Node node)
    {
        int n = 0;
        boolean zero = false , two = false;
        if (node.left == null && node.right == null)
            return 0;
        
        if (node.left != null)
        {
            n = traverse(node.left);
            if ( n==0 )
                zero = true;
            if ( n==2 )
                two = true;
        }
        
        if (node.right != null)
        {
            n = traverse(node.right);
            if ( n==0 )
                zero = true;
            if ( n==2 )
                two = true;
        }
        
        if ( zero )
        {
            ++result;
            return 2;
        }
        
        if ( two )
            return 1;
        return 0;
    }
}
