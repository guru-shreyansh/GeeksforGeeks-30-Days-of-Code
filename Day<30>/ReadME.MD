<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Escape the Forbidden Forest</h1>

`LCS`
`Strings`
`Dynamic Programming`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C30%3E/D30.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 30</h3>
<blockquote>Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get them. But Penelope has magical powers that can build bridges across the dangerous river and take her friends to safety. The only bridges that can withstand the Devil's wrath are the ones built between two similar trees in the forest. 
Given str1 and str2 denoting the order of trees on either side of the river, find the maximum number of bridges that Penelope can build and save everyone from the Devil. 
Note: Each tree in the forest belongs to one of the 3 categories represented by * or # or @.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;str1 = "\*@#\*"<br>
&emsp;&emsp;str2 = "\*#"<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: str1 = "\*@#\*" and str2 = "\*#". Two bridges can be built between the banks of the river in the following manner.<br>
&emsp;&emsp;**\*** @ **#** \*<br>
&emsp;&emsp;|&emsp;&emsp;|<br>
&emsp;&emsp;**\***&emsp; **#**<br>
* **Example 2**:<br>
&emsp;&emsp;str1 = "\*\*\*"<br>
&emsp;&emsp;str2 = "##"<br>
&emsp;&emsp;Output: 0<br>
&emsp;&emsp;Explanation: No tree of same category can be found between the side of the bank.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function build_bridges() that takes str1 and str2 as input parameters and returns the maximum number of bridges that can be built.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*M)</td> <td align="center">O(N*M)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` , ` M ` ≤  100<br>
Where, N and M are the size of the string str1 and str2 respectively.

###      ∑ HINTS ▸
- [x] _Find longest common subsequence._
```java
    public static int build_bridges(String str1 , String str2)
    {
        return longestCommonSubsequence(str1 , str2);
    }
    public static int longestCommonSubsequence(String S1, String S2)
    {
        char[] C1 = S1.toCharArray();
        char[] C2 = S2.toCharArray();
        
        int[][] _Dp = new int[C1.length + 1][C2.length + 1];
        for (int i=0; i<C1.length; i++)
            for (int j=0; j<C2.length; j++)
                _Dp[i+1][j+1] = C1[i] == C2[j]? _Dp[i][j]+1 : Math.max(_Dp[i][j+1], _Dp[i+1][j]);
                
        return _Dp[C1.length][C2.length];
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/a4f19ea532cee502aabec77c07e0d0a45b76ecf9/1/?track=30-DOC-day-30&batchId=320" align="left">706085</a>🖱</p>
<!--
#GURU ツ
-->
