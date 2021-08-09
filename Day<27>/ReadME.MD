<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Police and Thieves</h1>

`Greedy`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C27%3E/D27.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 27</h3>
<blockquote>Given an array of size N such that each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. Keep in mind the following conditions :
1) Each policeman can catch only one thief.
2) A policeman cannot catch a thief who is more than K units away from him.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 5, K = 1<br>
&emsp;&emsp;arr[ ] = {P, T, T, P, T}<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 6, K = 2<br>
&emsp;&emsp;arr[ ] = {T, T, P, P, T, P}<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: Maximum 3 thieves can be caught.<br>

**➔ Your Task**:
<mark>You dont need to read input or print anything. Complete the function catchThieves() that takes n, k and arr[ ] as input parameters and returns the maximum number of thieves that can be caught by the police. </mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` K ` ≤  100
` arr[i] ` = 'P' or 'T'

###      ∑ HINTS ▸
- [x] _Use Greedy approach._
```java
    static int catchThieves(char arr[], int n, int k) 
	{
	    int max = 0;
	    boolean[] police = new boolean[n];  // Storing indices of Police
	    Arrays.fill(police , false);
	    
	    for (int i=0; i<n; i++)
	        if ( arr[i]=='P' )
	            police[i] = true;
	    outer:
	    for (int i=0; i<n; i++)             // Searching for the Thief
	    {
	        if ( arr[i]=='T' )
	        {
	            for (int j=i-k; j<=i+k; j++)
	            {
	                if (j<0 || j==i || n<=j)
	                    continue;
	                else if ( police[j]==true )
	                {
	                    police[j] = false;
	                    ++max;
	                    continue outer;
	                }
	            }
	        }
	    }
	    return max;
	}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/e47329920b4e75869ea7b0e9b7c59ea145ccc22c/1/?track=30-DOC-day-27&batchId=320" align="left">705822</a>🖱</p>
<!--
#GURU ツ
-->
