<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%233.png" width="100">
<h1>:people_holding_hands: Corona Vaccine</h1>

`Tree`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D21.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 21</h3>
<blockquote>Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes. </blockquote>

* **Example 1**:<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D21.a.png" height="300" width="180"><br><br><br><br><br><br><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: The vaccine kits should be supplied to house numbers 1 and 5.<br>
* **Example 2**:<br>
<img align='left' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C21%3E/D21.b.png" height="150" width="200"><br><br><br><br><br><br><br>
&emsp;&emsp;Output: 1<br>
&emsp;&emsp;Explanation: The vaccine kits should be supplied to house number 1.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function supplyVaccine() which takes the root of the housing tree as input parameter and returns the minimum number of houses that should be supplied with the vaccine kit.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _Use Greedy approach to take care of the following types of cases
- [ ] _1. Node is a leaf node_
- [ ] _2. Node is already covered by another node_
- [ ] _3. Node itself has the vaccine kit_
```java
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
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
