<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%231.png" width="100">
<h1>:people_holding_hands: Spiral Matrix</h1>

`Matrix`
`Arrays`
`Constructive Algorithms`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C05%3E/D05.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 5</h3>
<blockquote>Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 3, M = 3, K = 4<br>
&emsp;&emsp;A[ ] = {{1, 2, 3},<br>
&emsp;&emsp;&emsp;&emsp;&emsp;{4, 5, 6},<br>
&emsp;&emsp;&emsp;&emsp;&emsp;{7, 8, 9}}<br>
&emsp;&emsp;Output: 6<br>
&emsp;&emsp;Explanation: Spiral traversal of matrix: {1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element is 6.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 2, M = 2, K = 2<br>
&emsp;&emsp;A[ ] = {{1, 2},<br>
&emsp;&emsp;&emsp;&emsp;&emsp;{3, 4}}<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: Spiral traversal of matrix: {1, 2, 4, 3}. Second element is 2.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function findK() which takes the matrix A[ ][ ], number of rows N, number of columns M, and integer K as input parameters and returns the Kth element in the spiral traversal of the matrix.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*M)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` K ` ≤ ` N*M ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _Simply traverse it spirally._
```java
static int findK( int arr[][], int rowEnd, int columnEnd, int K)
{
    int k = 1;
    int i, rowStart = 0, columnStart = 0;

    while (rowStart < rowEnd && columnStart < columnEnd)
    {
        for (i = columnStart; i < columnEnd; ++i, ++k)
            if ( k==K )
                return arr[rowStart][i];
        rowStart++;

        for (i = rowStart; i < rowEnd; ++i, ++k)
            if ( k==K )
                return arr[i][columnEnd - 1];
        columnEnd--;

        if (rowStart < rowEnd)
        {
            for (i = columnEnd - 1; i >= columnStart; --i, ++k)
                if ( k==K )
                    return arr[rowEnd - 1][i];
            rowEnd--;
        }
			
        if (columnStart < columnEnd)
        {
            for (i = rowEnd - 1; i >= rowStart; --i, ++k)
                if ( k==K )
                    return arr[i][columnStart];
            columnStart++;
        }
    }
    return -1;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/cd61add036272faa69c6814e34aa7007d5a25aa6/1/?track=30-DOC-day-5&batchId=320" align="left">706061</a>🖱</p>
<!--
#GURU ツ
-->
