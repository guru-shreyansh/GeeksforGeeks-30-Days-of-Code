<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Ruling Pair</h1>

`Array`
`Hashing`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C14%3E/D14.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 14</h3>
<blockquote>Geek Land has a population of N people and each person's ability to rule the town is measured by a numeric value arr[i]. The two people that can together rule Geek Land must be compatible with each other i.e., the sum of digits of their ability arr[i] must be equal. Their combined ability should be maximum amongst all the possible pairs of people. Find the combined ability of the Ruling Pair.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;arr[ ] = {55, 23, 32, 46, 88}<br>
&emsp;&emsp;Output: 101<br>
&emsp;&emsp;Explanation: All possible pairs that are compatible with each other are- (23, 32) with digit sum 5 and (55, 46) with digit sum 10. Out of these the maximum combined ability pair is (55, 46) i.e. 55 + 46 = 101<br>
* **Example 2**:<br>
&emsp;&emsp;N = 4<br>
&emsp;&emsp;arr[ ] = {18, 19, 23, 15}<br>
&emsp;&emsp;Output: -1<br>
&emsp;&emsp;Explanation: No two people are compatible with each other.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function RulingPair() which takes the array arr[] and size of array N as input parameters and returns the answer. If No two people are compatible with each other then return -1.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` arr[i] ` ≤  10⁹

###      ∑ HINTS ▸
- [x] _Traverse through the array and use a unordered_map to store the maximum number present for a particular digit sum._
```java
    static int RulingPair(int arr[], int n)
	{
	    int[] map = new int[76];            // Map with indexes as possible digit sum
	    int maxPair = -1;
	    int value = 0;
	    for (int temp : arr)
	    {
	        int sumOfDigits = digitSum(temp);   // Calculating sum of digits
	        if (0 < map[sumOfDigits])             // If a value with same digit sum
	        {                                       // is already present 
	            value = map[sumOfDigits];
	            maxPair = Math.max(maxPair, value+temp);
	            if (value < temp)                       // Replacing the element if current value
	                map[sumOfDigits] = temp;            // is greater than the previous value
	        }
	        else 
	            map[sumOfDigits] = temp;
	    }
	    return maxPair;
	}
	static int digitSum(int n)
	{
	    int sum = 0;
	    while (0 < n)
	    {
	        sum += (n % 10);
	        n /= 10;
	    }
	    return sum;
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/974612adac31d8e35448df5879342690f841c532/1/?track=30-DOC-day-14&batchId=320" align="left">706070</a>🖱</p>
<!--
#GURU ツ
-->
