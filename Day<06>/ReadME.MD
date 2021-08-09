<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%231.png" width="100">
<h1>:people_holding_hands: Coins of Geekland</h1>

`Arrays`
`Matrix`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C06%3E/D06.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 6</h3>
<blockquote>In Geekland there is a grid of coins of size N x N. You have to find the maximum sum of coins in any sub-grid of size K x K.
<b>Note:</b> Coins of the negative denomination are also possible at Geekland.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;Input: N = 5, K = 3<br>
&emsp;&emsp;mat[[ ]] = {1, 1, 1, 1, 1} 
          {2, 2, 2, 2, 2} 
          {3, 8, 6, 7, 3} 
          {4, 4, 4, 4, 4} 
          {5, 5, 5, 5, 5}<br>
&emsp;&emsp;Output: 48<br>
&emsp;&emsp;Explanation: {8, 6, 7}
             {4, 4, 4}
             {5, 5, 5} has the maximum sum<br>
* **Example 2**:<br>
&emsp;&emsp;N = 1, K = 1<br>
&emsp;&emsp;mat[[ ]] = {{4}}<br>
&emsp;&emsp;Output: 4<br>
&emsp;&emsp;Explanation: NaN<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function Maximum_Sum() which takes the matrix mat[], size of Matrix N, and value K as input parameters and returns the maximum sum.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N²)</td> <td align="center">O(N²)</td></tr>
</table>

#### < Constraints >
1  ≤ ` K ` ≤ ` N ` ≤  10³<br>
-5\*10⁵  ≤ ` mat[i][j] ` ≤  5\*10⁵

###      ∑ HINTS ▸
- [x] _Apply 2d prefix sum_
```java
public int Maximum_Sum(int mat[][], int n, int k)
{
    int[][] preSUM = new int[n-k+1][n]; // Array to store sum of all vertical 
    int i=0, j=0;                       //      sub-matrices of size 1*K
    for (j=0; j<n; j++)
        for (i=0; i<k; i++)
            preSUM[0][j] += mat[i][j];

    for (j=0; j<n; j++)
        for (i=1; i<=n-k; i++)
            preSUM[i][j] = preSUM[i-1][j] - mat[i-1][j] + mat[i+k-1][j];
        
    int currSUM = 0;                // Efficiently calculating sum of all possible
    int max = Integer.MIN_VALUE;    //          sub-matrices of size k*k
    for (i=0; i<n-k+1; i++)
    {
        currSUM = 0;
        for (j=0; j<k; j++)
            currSUM += preSUM[i][j];
        max = Math.max(max , currSUM);
        for (j=1; j<n-k+1; j++)
        {
            currSUM = currSUM - preSUM[i][j-1] + preSUM[i][j+k-1];
            max = Math.max(max , currSUM);
        }
    }
    return max;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/257a9e27fb3e58255622c8dcb06e0919cc1c6c11/1/?track=30-DOC-day-6&batchId=320" align="left">706062</a>🖱</p>
<!--
#GURU ツ
-->
