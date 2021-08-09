<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%231.png" width="100">
<h1>:people_holding_hands: Smallest Positive Integer that can not be represented as Sum</h1>

`Arrays`
`Sorting`
`Mathematical`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C03%3E/D03.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 3</h3>
<blockquote>Given an array of size N, find the smallest positive integer value that cannot be represented as sum of some elements from the array.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 6<br>
&emsp;&emsp;array[ ] = {1, 10, 3, 11, 6, 15}<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: 2 is the smallest integer value that cannot be represented as sum of elements from the array.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 3<br>
&emsp;&emsp;array[ ] = {1, 1, 1}<br>
&emsp;&emsp;Output: 4<br>
&emsp;&emsp;Explanation: 1 is present in the array. 2 can be created by combining two 1s. 3 can be created by combining three 1s. 4 is the smallest integer value that cannot be 
represented as sum of elements from the array.<br>

**➔ Your Task**:
<mark>You dont need to read input or print anything. Complete the function smallestpositive() which takes the array and N as input parameters and returns 
  the smallest positive integer value that cannot be represented as sum of some elements from the array.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N * Log(N))</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁶<br>
1  ≤ ` a[i] ` ≤  10⁹  (Array may contain duplicates.)

###      ∑ HINTS ▸
- [x] _Sort the array. Then traverse the sorted array from left to right and observe the numbers you are able to build with each addition._
```java
long smallestpositive(long[] array, int n)
{
    Arrays.sort(array);
    long currNumber = 1L;               // Minimum positive output
    for (int i=0; i<array.length; i++)
    {
        if (array[i] <= currNumber)
            currNumber += array[i];
        else 
            break;
    }
    return currNumber;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/b6b608d4eb1c45f2b5cace77c4914f302ff0f80d/1/?track=30-DOC-day-3&batchId=320" align="left">706045</a>🖱</p>
<!--
#GURU ツ
-->
