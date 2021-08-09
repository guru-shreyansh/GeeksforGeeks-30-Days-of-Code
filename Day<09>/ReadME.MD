<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Easy%231.png" width="100">
<h1>:people_holding_hands: Transfiguration</h1>

`String`
`Hash`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C09%3E/D09.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 9</h3>
<blockquote>Professor McGonagall teaches transfiguration at Hogwarts. She has given Harry the task of changing himself into a cat. She explains that the trick is to analyze your own DNA and change it into the DNA of a cat. The transfigure spell can be used to pick any one character from the DNA string, remove it and insert it in the beginning. 
Help Harry calculates minimum number of times he needs to use the spell to change himself into a cat.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;A = "GEEKSFORGEEKS"<br>
&emsp;&emsp;B = "FORGEEKSGEEKS"<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: The conversion can take place in 3 operations:
1. Pick 'R' and place it at the front, A="RGEEKSFOGEEKS"
2. Pick 'O' and place it at the front, A="ORGEEKSFGEEKS"
3. Pick 'F' and place it at the front, A="FORGEEKSGEEKS"<br>
* **Example 2**:<br>
&emsp;&emsp;A = "ABC"<br>
&emsp;&emsp;B = "BCA"<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: The conversion can take place in 2 operations:
1. Pick 'C' and place it at the front, A = "CAB"
2. Pick 'B' and place it at the front, A = "BCA"<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function transfigure() which takes strings A and B as input parameters and returns the minimum number of spells needed. If it is not possible to convert A to B then return -1.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(max(|A| , |B|)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` |A| ` , ` |B| ` ≤  10⁵<br>
`A` and `B` consists of lowercase and uppercase letters of english alphabet only.

###      ∑ HINTS ▸
- [x] _Firsly, we need to check whether such a conversion is possible or not, the frequency of all the elements in A must be same as the frequency of all the elements in B._
- [x] _Start matching from last characters of both strings. If last characters match, then our task reduces to remaining characters. If last characters don’t match, then find the position of B’s mismatching character in A. The difference between two positions indicates that these many characters of A must be moved._
```java
int transfigure(String A, String B)
{
    int i = 0, j = 0;
    int len = A.length();
    if ( len != B.length() ) return -1;
    	
    char[] aaa = new StringBuilder(A).reverse().toString().toCharArray();
    char[] bbb = new StringBuilder(B).reverse().toString().toCharArray();
    int[] freq = new int[128];
    	
    for (i = 0; i<len; i++)     ++freq[ (int)aaa[i] ];
    for (i = 0; i<len; i++)     --freq[ (int)bbb[i] ];
    for (i = 0; i<128; i++)
    	  if ( freq[i] != 0 )
    	      return -1;
    	
    int matched = 0; i=j=0;
    while ( j<len )
    {
    	  while ( j<len && bbb[i]!=aaa[j] )
    	      ++j;
    	  if ( j<len )
    	  {
    	      ++i; ++j;
    	      ++matched;
    	  }
    }
    return len - matched;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/b6b3297ccfb1ad5f66a9c2b92979170417adf114/1/?track=30-DOC-day-9&batchId=320" align="left">706065</a>🖱</p>
<!--
#GURU ツ
-->
