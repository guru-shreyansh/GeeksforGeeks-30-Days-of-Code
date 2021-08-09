<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Bit Difference</h1>

`Bit`
`Bit Magic`
`Bit Manipulation`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C12%3E/D12.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 12</h3>
<blockquote>Given an integer array of size  N . You have to find sum of bit differences in all pairs that can be formed from array elements. Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 (first and last bits differ in two numbers).</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 2<br>
&emsp;&emsp;arr[ ] = {1, 2}<br>
&emsp;&emsp;Output: 4<br>
&emsp;&emsp;Explanation: All possible pairs are [(1,1) (1,2) (2,1) (2,2)] their respective Bit differences are 0 ,  2 , 2 , 0.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;arr[ ] = {3, 5, 2, 5, 2}<br>
&emsp;&emsp;Output: 36<br>
&emsp;&emsp;Explanation: NaN<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function sumBitDiff() which takes the array a[] and size of array N as input parameters and returns the answer.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*log(N))</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` arr[i] ` ≤  10⁸

###      ∑ HINTS ▸
- [x] _Find some mathematical formula using information of total number of set bits in all the numbers at a particular ith bit position._
```java
public static long sumBitDiff(int arr[], int n)
{                                             // O( NlogN ) Solution
    long even = 0L;
    long zeros = 0L;
    long diffSum = 0L;
    for ( int i=1; i<=32; i++ )
    {
        even = 0L;
        zeros = 0L;
        for ( int j=0; j<n; j++ )
        {
            if ( arr[j] % 2 == 0 )
                ++even;
            if ( arr[j] == 0 )
                ++zeros;
            arr[j] /= 2;
        }
        if ( zeros == n )
            return 2*diffSum;
        diffSum += (even) * (n-even);
    }
    return 2*diffSum;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/760a2a0627f1abf231de42b93bb71825ecbcb3b4/1/?track=30-DOC-day-12&batchId=320" align="left">706069</a>🖱</p>
<!--
#GURU ツ
-->
