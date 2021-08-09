<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%231.png" width="100">
<h1>:people_holding_hands: Dam of Candies</h1>

`Arrays`
`Two-Pointer Algorithm`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C08%3E/D08.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 8</h3>
<blockquote>Geek wants to make a special space for candies on his bookshelf. Currently, it has N books of different heights and unit width. Help him select 2 books such that he can store maximum candies between them by removing all the other books from between the selected books. The task is to find out the area between 2 books that can hold the maximum candies without changing the original position of selected books.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 3<br>
&emsp;&emsp;height[ ] = {1, 3, 4}<br>
&emsp;&emsp;Output: 1<br>
&emsp;&emsp;Explanation: 1. Area between book of height 1 and book of height 3 is 0 as there is no space between them.
2. Area between book of height 1 and book of height 4 is 1 by removing book of height 3.
3. Area between book of height 3 and book of height 4 is 0 as there is no space between them.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 6<br>
&emsp;&emsp;height[ ] = {2, 1, 3, 4, 6, 5}<br>
&emsp;&emsp;Output: 8<br>
&emsp;&emsp;Explanation: We remove the 4 books in the middle creating length = 4 for the candy dam. Height for dam will be min(2,5) = 2. Area between book of height 2 and book of height 5 is 2 x 4 = 8.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function maxCandy() which takes the array height[] and size of array N as input parameters and returns the maximum candies geek can store.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>

###      ∑ HINTS ▸
- [x] _The aim is to maximize the area formed between the 2 vertical books. The shorter book forms the length of the candy dam and the distance between the books is the width of the rectangle._
- [x] _Use two pointer approach. Start with the maximum width possible for the candy dam, ie first and last book. Go to a shorter width only if there is a book longer than the current book._
```java
static int maxCandy(int height[], int n)
{
    if ( n < 3 )    return 0;
    int start = 0;
    int end = n-1;
    int currArea = 0;
    int maxFound = ( n-2 )*( Math.min(height[0] , height[n-1]) );
	    
    while ( start < end )
    {
    	currArea = Math.min(height[start] , height[end]) * (end-start-1);
		maxFound = Math.max(currArea , maxFound);
	        
		if ( height[start] < height[end] )
	    	++start;
		else 
	    	--end;
	}
	return maxFound;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/10471201e923a0b88a0c1482e6c7e8cc6fdfe93a/1/?track=30-DOC-day-8&batchId=320" align="left">706064</a>🖱</p>
<!--
#GURU ツ
-->
