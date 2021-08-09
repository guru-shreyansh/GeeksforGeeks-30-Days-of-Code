<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Repeated String Match</h1>

`Strings`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C10%3E/D10.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 10</h3>
<blockquote>Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A. If B cannot be a substring of A no matter how many times it is repeated, return -1.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;A = "abcd"<br>
&emsp;&emsp;B = "cdabcdab"<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: After repeating A three times, we get "abcdabcdabcd".<br>
* **Example 2**:<br>
&emsp;&emsp;A = "aa"<br>
&emsp;&emsp;B = "a"<br>
&emsp;&emsp;Output: 1<br>
&emsp;&emsp;Explanation: B is already a substring of A.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function repeatedStringMatch() which takes strings A and B as input parameters and returns the minimum number of operations to complete the task. If it is not possible then return -1.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(|A| * |B|)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` |A| ` , ` |B| ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _Let count = B.length() / A.length(). Now check whether B is a substring of A*count or A*(count+1)_
```java
static int repeatedStringMatch(String A, String B) 
{
    if ( A.indexOf(B) != -1 )
        return 1;
	    
    StringBuilder aaa = new StringBuilder("");
    StringBuilder bbb = new StringBuilder("");
	    
    int length = B.length()+A.length();
    int repeated = 0;
	    
    while ( (aaa.indexOf(B) == -1) && (aaa.length() < length) )
    {
        aaa.append(A);
        ++repeated;	     
    }
	    
    if ( aaa.indexOf(B) == -1 )
        return -1;   
    return repeated;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/0cba668df04d657fde4d1bd28b626a01e61097f1/1/?track=30-DOC-day-10&batchId=320" align="left">706066</a>🖱</p>
<!--
#GURU ツ
-->
