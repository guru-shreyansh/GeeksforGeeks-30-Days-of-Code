<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%233.png" width="100">
<h1>:people_holding_hands: Elixir of Life</h1>

`Strings`
`Prefix`
`Suffix`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C29%3E/D29.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 29</h3>
<blockquote>Flamel is making the Elixir of Life but he is missing a secret ingredient, a set of contiguous plants (substring) from the Garden of Eden. The garden consists of various plants represented by string S where each letter represents a different plant.  But the prophecy has predicted that the correct set of plants required to make the potion will appear in the same contiguous pattern (substring) at the beginning of the forest (prefix), the end of the forest (suffix), and will also be the most frequent sequence present in the entire forest.
Identify the substring of plants required to make the elixir and find out the number of times it appears in the forest.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;S = "ababaaaab"<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: substring "ab" is a prefix, a suffix and appears 3 times.<br>
* **Example 2**:<br>
&emsp;&emsp;S = "aaaa"<br>
&emsp;&emsp;Output: 4<br>
&emsp;&emsp;Explanation: substring "aaaa" occurs 1 time, substring "aaa" occurs 2 times, substring "aa" occurs 3 times, substring "a" occurs 4 times. All of them are proper prefixes and suffixes. But, "a" has the maximum frequency.<br>
* **Example 3**:<br>
&emsp;&emsp;S = "abcdef"<br>
&emsp;&emsp;Output: 1<br>
&emsp;&emsp;Explanation: substring "abcdef" is the only prefix, a suffix and appears only once.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function maxFrequency() which takes string S as input parameter and returns the answer.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*logN)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` |S| ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _Use Z function algorithm_
```java
    int maxFrequency(String S)
    {
        String prefix = "", suffix = "";
        int N = S.length();
        int start = 0, end = N-1;
        int maxFreq = 1;
        int freq = 0;
        
        while ( start <= end )
        {
            prefix = S.substring(0 , start+1);  // prefix + C[start];
            suffix = S.substring(end);          // C[end] + suffix;
            if ( prefix.equals(suffix) )
            {
                freq = ( N - S.replaceAll(prefix,"").length() ) / prefix.length();
                if ( freq < maxFreq )           // If new Frequency is < Max Frequency
                    return maxFreq;                 // found so far we can't get
                maxFreq = Math.max( freq , maxFreq );   // a higher count
            }
            --end;
            ++start;
        }
        return maxFreq;
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
