<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Restricted Pacman</h1>

`Queue`
`Hashing`
`Mathematical`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C19%3E/D19.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 19</h3>
<blockquote>In the game of Restricted Pacman, an infinite linear path is given. Pacman has to start at position 0 and eat as many candies as possible. In one move he can only jump a distance of either M or N.  If M and N are coprime numbers, find how many candies will be left on the board after the game is over.
  <b>Note:</b> The result is always finite as after a point X every index in the infinite path can be visited.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;M = 2<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: From index 0, the indices that can be visited are
0 + 2 = 2
0 + 2 + 2 = 4
0 + 5 = 5
0 + 2 + 2 + 2 = 6
0 + 2 + 5 = 7
0 + 2 + 2 + 2 + 2 = 8
0 + 2 + 2 + 5 = 9
0 + 5 + 5 = 10 and so on.
1 and 3 are the only indices that cannot be visited. Therefore the candies at these two positions will be left on the board.<br>
* **Example 2**:<br>
&emsp;&emsp;M = 2<br>
&emsp;&emsp;N = 7<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: NaN<br>
* **Example 3**:<br>
&emsp;&emsp;M = 25<br>
&emsp;&emsp;N = 7<br>
&emsp;&emsp;Output: 72<br>
&emsp;&emsp;Explanation: NaN<br>
**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function candies() which take M and N as input parameters and return the answer.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` M ` , ` N ` ≤  500<br>

###      ∑ HINTS ▸
- [x] _Find the largest index that can’t be obtained using any combination of M & N using Frobenius Number which defines X = (M * N) – M – N. Add X to a queue. X is the largest index than cannot be visited so every index greater than X need not be checked. Now add X-M and X-N to the queue and so on. _
```java
    static int candies(int m, int n)
    {                               // Any number >= "LCM(m,n)-m-n" can be formed
        return (m-1)*(n-1)/2;       // So we only need to check for numbers less
    }                               //      than or equal to (mn - m - n)
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
