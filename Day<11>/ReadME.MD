<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%232.png" width="100">
<h1>:people_holding_hands: Secret Cipher</h1>

`Strings`
`Stack`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C11%3E/D11.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 11</h3>
<blockquote>Geek wants to send an encrypted message in the form of string S to his friend Keeg along with instructions on how to decipher the message. To decipher the message, his friend needs to iterate over the message string from left to right, if he finds a '*', he must remove it and add all the letters read so far to the string. He must keep on doing this till he gets rid of all the '*'.
Can you help Geek encrypt his message string S? 

<b>Note:</b> If the string can be encrypted in multiple ways, find the smallest encrypted string. </blockquote>

* **Example 1**:<br>
&emsp;&emsp;S = "ababcababcd"<br>
&emsp;&emsp;Output: ab*c*d<br>
&emsp;&emsp;Explanation: We can encrypt the string in following way : "ababcababcd" -> "ababc*d" -> "ab*c*d"<br>
* **Example 2**:<br>
&emsp;&emsp;S = "zzzzzzz"<br>
&emsp;&emsp;Output: z*z*z<br>
&emsp;&emsp;Explanation: The string can be encrypted in 2 ways: "z*z*z" and "z\*\*zzz". Out of the two "z*z*z" is smaller in length.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function secretCipher() which takes the message string S as input parameter and returns the shortest possible encrypted string.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` |S| ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _Find the longest proper prefix which is also a proper suffix for each prefix of the string._
```java
public String compress(String s)
{
    int i=0, n = s.length();
    ArrayList<Integer> sub = new ArrayList<>(n);
    for (i=0; i<n; i++)
    sub.add(0);
    StringBuilder secC = new StringBuilder("");
    for (i=1; i<n; i++)
    {
        int j = sub.get(i-1);
	while (0 < j && s.charAt(i) != s.charAt(j))
	    j = sub.get(j-1);
	if (s.charAt(i) == s.charAt(j))
	    j++;
	sub.set(i,j);
    }
    for (i=n-1; 0<=i; i--)
    {
	if (i%2 == 1)
	{
	    if ( (i+1)/2<=sub.get(i) && (i+1)%(2*(i+1-sub.get(i)))==0 )
	    {
	        secC.append( "*" );
	        i /= 2;
	        ++i;
	        }
	    else 
	        secC.append(s.charAt(i));
	}
	else 
	    secC.append(s.charAt(i));
    }
    return secC.reverse().toString();
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
