<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%232.png" width="100">
<h1>:people_holding_hands: 132 Geeky Buildings</h1>

`Array`
`Stack`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C18%3E/D18.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 18</h3>
<blockquote>There are N buildings in Linear Land. They appear in a linear line one after the other and their heights are given in the array arr[]. Geek wants to select three buildings in Linear Land and remodel them as recreational spots. The third of the selected building must be taller than the first and shorter than the second.
Can geek build the three-building recreational zone?</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 6<br>
&emsp;&emsp;arr[ ] = {4, 7, 11, 5, 13, 2}<br>
&emsp;&emsp;Output: True<br>
&emsp;&emsp;Explanation: [4, 7, 5] fits the condition.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 4<br>
&emsp;&emsp;arr[] = {11, 11, 12, 9}<br>
&emsp;&emsp;Output: False<br>
&emsp;&emsp;Explanation: No 3 buildings fit the given condition.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function recreationalSpot() which takes the array arr[] and its size N as input parameters and returns a boolean value based on whether his building selection was successful or not.
<b>Note:</b> The generated output will be "True" or "False".</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁴<br>
1  ≤ ` arr[i] ` ≤  10⁵

###      ∑ HINTS ▸
- [x] _Use a stack._
```java
    static boolean recreationalSpot(int[] arr , int n)
    {
        int currMin = arr[0], currMax = arr[0];
        
        for (int i=1; i<n; i++)
        {
            currMin = Math.min(arr[i] , currMin);
            currMax = Math.max(arr[i] , currMax);
            
            if ( arr[i] < currMax && currMin < arr[i] )
                return true;
        }
        return false; 
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/355f731797ea1acbd5ab698b19eb1c3c469aa837/1/?track=30-DOC-day-18&batchId=320" align="left">706074</a>🖱</p>
<!--
#GURU ツ
-->
