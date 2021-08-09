<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Restrictive Candy Crush</h1>

`Strings`
`Stack`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C16%3E/D16.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 16</h3>
<blockquote>Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;K = 2<br>
&emsp;&emsp;S = "geeksforgeeks"<br>
&emsp;&emsp;Output: gksforgks<br>
&emsp;&emsp;Explanation: Modified String after each step: "geeksforgeeks" -> "gksforgks"<br>
* **Example 2**:<br>
&emsp;&emsp;K = 2<br>
&emsp;&emsp;S = "geegsforgeeeks"<br>
&emsp;&emsp;Output: sforgeks<br>
&emsp;&emsp;Explanation: Modified String after each step: "geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function Reduced_String() which takes integer K and string S as input parameters and returns the reduced string.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(|S|)</td> <td align="center">O(|S|)</td></tr>
</table>

#### < Constraints >
1  ≤ ` |S| ` ≤  10⁵<br>
1  ≤ ` K ` ≤  |S|

###      ∑ HINTS ▸
- [x] _Iterate over the string and use a stack to keep count of appearaces of every character._
- [x] _Every element of stack will hold information for the character and its number of consecutive appearances._
- [x] _If count reaches k, pop the stack entry._
```java
    public static String reduced_String(int k, String s)
    {
        if (k==1) return "";
        StringBuilder output = new StringBuilder(s);
        int count[] = new int[output.length()];
    
        for(int i=0; i<output.length(); i++)
        {
            if( i==0 || output.charAt(i) != output.charAt(i-1) )
                count[i] = 1;
            else
            {
                count[i] = count[i-1] + 1;
                if(count[i]==k)
                {
                    output.delete(i-k+1,i+1);
                    i = i-k;
                }   
            }
        }
        return output.toString();
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/8c8f95810b05b4cab665f2997d36991bd58308a2/1/?track=30-DOC-day-16&batchId=320" align="left">706072</a>🖱</p>
<!--
#GURU ツ
-->
