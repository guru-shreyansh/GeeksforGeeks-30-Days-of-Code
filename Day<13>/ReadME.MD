<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%232.png" width="100">
<h1>:people_holding_hands: Check Tree Traversal</h1>

`Tree`
`Recursion`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C13%3E/D13.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 13</h3>
<blockquote>Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;preorder[ ] = {1, 2, 4, 5, 3}<br>
&emsp;&emsp;inorder[ ] = {4, 2, 5, 1, 3}<br>
&emsp;&emsp;postorder[ ] = {4, 5, 2, 3, 1}<br>
&emsp;&emsp;Output: Yes<br>
&emsp;&emsp;Explanation: All of the above three traversals are of the same tree.<br>
............1<br>
........../...\\<br>
........2.....3<br>
....../...\\....<br>
....4.....5...<br>
* **Example 2**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;preorder[ ] = {1, 5, 4, 2, 3}<br>
&emsp;&emsp;inorder[ ] = {4, 2, 5, 1, 3}<br>
&emsp;&emsp;postorder[ ] = {4, 1, 2, 3, 5}<br>
&emsp;&emsp;Output: No<br>
&emsp;&emsp;Explanation: The three traversals can not be of the same tree.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function checktree() which takes the array preorder[ ], inorder[ ], postorder[ ] and integer N as input parameters and returns true if the three traversals are of the same tree or not.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N²)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10³<br> 

###      ∑ HINTS ▸
- [x] _The root element will be the first element of preorder._
- [x] _Search for root in the inorder array and store it’s index as idx._
- [x] _Use this idx to determine elements of left and right subtree in all three traversal arrays._
- [x] _Call function recursively for both left and right sub tree._
```java
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
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
