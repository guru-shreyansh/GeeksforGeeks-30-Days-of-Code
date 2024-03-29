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
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

class Solution
{
    static int range, sum, key;
    static int sum_at_distK(Node root, int target, int k)
    {
        sum = 0;
        range = k;
        key = target;
        find(root, k);
        return sum;
    }
    static int find(Node root, int k)
    {
        if (root == null)
            return -1;
        if (root.data == key)
        {
            sum += root.data;
            k--;
            find(root.left, k);
            find(root.right, k);
            return k--;
        }
        else if (k != range && 0 <= k)
        {
            sum += root.data;
            k--;
            find(root.left, k);
            find(root.right, k);
            return -1;
        }
        else if (k < 0)
            return -1;
        else
		{
            int k1 = find(root.left, k);
            int k2 = find(root.right, k);
            if (k1 != -1)
            {
                sum += root.data;
                find(root.right, k1-1);
                return k1-1;
            }
            if (k2 != -1)
            {
                sum += root.data;
                find(root.left, k2-1);
                return k2-1;
            }
            return -1;
        }
    }
}
