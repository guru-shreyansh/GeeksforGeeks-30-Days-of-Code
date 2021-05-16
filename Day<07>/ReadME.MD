<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%231.png" width="100">
<h1>:people_holding_hands: Valid Pair Sum</h1>

`Arrays`
`Greedy`
`Sorting`
`Searching`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C07%3E/D07.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 7</h3>
<blockquote>Given an array of size N, find the number of distinct pairs {a[i], a[j]} (i != j) in the array with their sum greater than 0.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 3<br>
&emsp;&emsp;a[ ] = {3, -2, 1}<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: {3, -2}, {3, 1} are two possible pairs.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 4<br>
&emsp;&emsp;a[ ] = {-1, -1, -1, 0}<br>
&emsp;&emsp;Output: 0<br>
&emsp;&emsp;Explanation: There are no possible pairs.<br>

**➔ Your Task**:
<mark>There are no possible pairs.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N * Log(N))</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
-10⁴  ≤ ` a[i] ` ≤  10⁴

###      ∑ HINTS ▸
- [x] _Sort the given array._
- [x] _For every positive number array[i], binary search for first element (let say index be j) ≥ (-array[i] + 1)_
- [x] _All values between [i, j] are valid pairs with their sum > 0_
```java
static long ValidPair(int arr[], int n)
{
    boolean allPositive = true, allNonPositive = true; int i=0;
    for (i=0; i<n; i++) if (arr[i] < 1) allPositive = false;
    for (i=0; i<n; i++) if (0 < arr[i]) allNonPositive = false;
    if (allPositive)    return (long)n*((long)n-1L)/2L;
    if (allNonPositive) return 0;
	        
    // If all elements are +ve (>=1)
    // If all elements are -ve or 0 (<=0)
	    
    Arrays.sort(arr);
    int j=0, key=0, end=n-1;
    long validPairs = 0L;
	    
    for (i=1; i<n; i++)
    {
        if (arr[i] <= 0)
	    continue;
	j=0;
	key = -arr[i];
	j = FirstElementStrictlyGreaterThanTheKey(arr,key,0,end);
	        
	end = j;                       // Storing the position of found key
	validPairs += (long)(i-j);          // to optimize the code
    }
    return validPairs;
}
	
static int FirstElementStrictlyGreaterThanTheKey(int[] arr, int key, int start, int end)
{
    int pos = -1;
    while (start <= end)
    {
        int mid = (start + end) / 2;
        if (arr[mid] <= key)
            start = mid + 1;
        else
        {
            pos = mid;
            end = mid - 1;
        }
    }
    return pos;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"> </p>
<!--
#GURU ツ
-->
