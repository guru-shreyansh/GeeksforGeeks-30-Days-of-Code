<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%231.png" width="100">
<h1>:people_holding_hands: Nth Natural Number</h1>

`Mathematical`
`Number System`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C01%3E/D02.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 2</h3>
<blockquote>Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 8<br>
&emsp;&emsp;Output: 8<br>
&emsp;&emsp;Explanation: After removing natural numbers which contains digit 9, first 8 numbers are 1,2,3,4,5,6,7,8 and 8th number is 8.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 9<br>
&emsp;&emsp;Output: 10<br>
&emsp;&emsp;Explanation: After removing natural numbers which contains digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10 and 9th number is 10.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function findNth() which accepts an integer N as input parameter and return the Nth number
  after removing all the numbers containing digit 9.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(logN)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10¹²<br>

###      ∑ HINTS ▸
- [x] _Observe carefully, base of the given sequence after changes._
```java
long findNth(long N)
{
      StringBuilder sss = new StringBuilder("");
      while ( 0 < N )
      {
            sss.append(N % 9);
            N /= 9;
      }
      return Long.valueOf(sss.reverse().toString());
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"> </p>
<!--
#GURU ツ
-->
