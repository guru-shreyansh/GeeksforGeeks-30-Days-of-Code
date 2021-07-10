<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%233.png" width="100">
<h1>:people_holding_hands: Shortest Range In BST </h1>

`Two-Pointer Algorithm`
`Tree`
`Binary Search Tree`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C22%3E/D22.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 22</h3>
<blockquote>Given a BST (Binary Search Tree), find the shortest range [x, y], such that, at least one node of every level of the BST lies in the range.
If there are multiple ranges with the same gap (i.e. (y-x)) return the range with the smallest x.</blockquote>

* **Example 1**:<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D22.a.png" height="300" width="250"><br><br><br><br><br><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 6 11<br>
&emsp;&emsp;Explanation: Level order traversal of the tree is [8], [3, 10], [2, 6, 14], [4, 7, 12], [11, 13]. The shortest range which satisfies the above mentioned condition is [6, 11].<br>
* **Example 2**:<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D22.a.png" height="300" width="250"><img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D22.b.png" height="300" width="180"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 12 16<br>
&emsp;&emsp;Explanation: Each level contains one node, so the shortest range is [12, 16].<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function shortestRange() which takes the root of the tree as an input parameter and returns the pair of numbers.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` Node Value ` ≤  10⁴

###      ∑ HINTS ▸
- [x] _Use two pointer technique in inorder traversal of the tree. Set left pointer at first index and right pointer at root's index in inorder traversal of the bst. Then check if the current range contains all levels if yes the shift left pointer 1 index right, otherwise increase the right pointer by 1. Continue this process till left pointer reaches the root's index or right pointer reaches last index._
```java
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
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
