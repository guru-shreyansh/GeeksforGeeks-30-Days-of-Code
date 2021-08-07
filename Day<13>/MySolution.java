import java.util.*;
import java.lang.*;
import java.io.*;

class GURU
{
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
		{
            int n = sc.nextInt();
            int[] preorder = new int[n];
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            for (int i=0; i<n; i++)
                preorder[i] = sc.nextInt();
            for (int i=0; i<n; i++)
                inorder[i] = sc.nextInt();
            for (int i=0; i<n; i++)
                postorder[i] = sc.nextInt();
            Solution ob = new Solution();
            if (ob.checktree(preorder, inorder, postorder, n))
				System.out.println("Yes");
	    	else
				System.out.println("No");
            t--;
        }
    }
}

class Solution
{
    static int index = 0;
    static boolean checktree(int preorder[], int inorder[], int postorder[], int len)
    {
        int xorIn = inorder[0];
        int xorPre = preorder[0];
        int xorPost = postorder[0];
        for (int i=1; i<len; i++)
        {
            xorIn ^= inorder[i];
            xorPre ^= preorder[i];
            xorPost ^= postorder[i];
        }
        if ( !(xorIn==xorPre && xorPre==xorPost) )
            return false;
        TreeNode root = buildTree(preorder,inorder,0,preorder.length-1);
        index = 0;
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        int myPost[] = new int[len];
        for (int i=0; i<len; i++)
            myPost[i]=list.get(i);
        for (int i=0; i<len; i++)
            if (myPost[i] != postorder[i])
                return false;
        
        return true;
    }
    static void postOrder(TreeNode root, List<Integer> list)
    {
        if (root==null) return;
        
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.data);
    }
    static TreeNode buildTree(int[] pre, int in[], int l, int r)
    {
        if (r < l || pre.length <= index)
           return null;
        
        int idx = 0;
        TreeNode root = new TreeNode(pre[index++]);
        for (int i=0; i<in.length; i++)
        {
            if (in[i] == root.data)
            {
                idx=i;
                break;
            }
        }
        root.left = buildTree(pre, in, l, idx-1);
        root.right = buildTree(pre, in, idx+1, r);
        return root;
    }
}
class TreeNode
{
    int data;
    TreeNode left, right;
    TreeNode(int data)
    {
        this.data = data;
        left = right = null;
    }
}
