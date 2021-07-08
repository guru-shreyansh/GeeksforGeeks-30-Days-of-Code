<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Valentine Sum</h1>

`Tree`
`Binary Search Tree`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C20%3E/D20.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 20</h3>
<blockquote>Cupid wants to strike maximum houses in Geek Land on Valentine's Day. The houses in Geek Land are arranged in the form of a binary tree. Cupid is standing at target node initially. Find the sum of all nodes within a maximum distance k from target node. The target node should be included in the sum.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;Target = 9<br>
&emsp;&emsp;K = 1<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C20%3E/D20.a.png" height="180" width="300"><br><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 22<br>
&emsp;&emsp;Explanation: Nodes within distance 1 from 9 are 9, 5, 7, 1.<br>
* **Example 2**:<br>
&emsp;&emsp;Target = 40<br>
&emsp;&emsp;K = 2<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C20%3E/D20.a.png" height="180" width="300"><br><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 113<br>
&emsp;&emsp;Explanation: Nodes within distance 2 from 40 are 40, 19, 50, 4.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function sum_at_distK() which takes the root of the tree, target, and K  as input parameter and returns the sum of all nodes within a max distance of k from the target.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` , ` Node Value ` ≤  10⁵<br>
1  ≤ ` K ` ≤  20

###      ∑ HINTS ▸
- [x] _Traverse over the tree while looking for target node, if found, add values of all nodes below it within distance k and return the distance from node._
```java
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
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
