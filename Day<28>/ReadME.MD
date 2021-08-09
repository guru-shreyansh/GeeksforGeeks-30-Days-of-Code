<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Water the plants</h1>

`Greedy`
`Sorting`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C28%3E/D28.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 28</h3>
<blockquote>A gallery with plants is divided into n parts, numbered : 0,1,2,3...n-1. There are provisions for attaching water sprinklers at every partition. A sprinkler with range x at partition i can water all partitions from i-x to i+x.
Given an array gallery[ ] consisting of n integers, where gallery[i] is the range of sprinkler at partition i (power==-1 indicates no sprinkler attached), return the minimum number of sprinklers that need to be turned on to water the complete gallery.
If there is no possible way to water the full length using the given sprinklers, print -1.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;n = 6<br>
&emsp;&emsp;gallery[ ] = {-1, 2, 2, -1, 0, 0}<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: Sprinklers at index 2 and 5 can water thefull gallery, span of sprinkler at index 2 = [0,4] and span of sprinkler at index 5 = [5,5].<br>
* **Example 2**:<br>
&emsp;&emsp;n = 9<br>
&emsp;&emsp;gallery[ ] = {2, 3, 4, -1, 2, 0, 0, -1, 0}<br>
&emsp;&emsp;Output: -1<br>
&emsp;&emsp;Explanation: No sprinkler can throw water at index 7. Hence all plants cannot be watered.<br>
* **Example 3**:<br>
&emsp;&emsp;n = 9<br>
&emsp;&emsp;gallery[ ] = {2, 3, 4, -1, 0, 0, 0, 0, 0}<br>
&emsp;&emsp;Output: 3<br>
&emsp;&emsp;Explanation: Sprinkler at indexes 2, 7 and 8 together can water all plants.<br>

**➔ Your Task**:
<mark>Your task is to complete the function min_sprinklers() which takes the array gallery[ ] and the integer n as input parameters and returns the value to be printed.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*logN)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` n ` ≤  10⁵<br>
` gallery[i] ` ≤  50

###      ∑ HINTS ▸
- [x] _Make a list/vector of all sprinklers and sort them wrt the starting point of their span._
_Now set the target at the start of the gallery and select the sprinkler which covers the target and reaches the furthest possible point (end of span)._
_Now, the target point moves one unit ahead of the end of span of the previously selected sprinkler. Repeat this process of selecting sprinklers till the complete gallery is covered._
```java
    int min_sprinklers(int gallery[], int n)
    {
        ArrayList<ArrayList<Integer>> sprinklers = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<n; i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            if ( gallery[i] != -1 )
            {
                row.add( Math.max(0 , i-gallery[i]) );
                row.add( Math.min(i+gallery[i] , n-1) );
                sprinklers.add( row );
            }
        }
        sprinklers.sort( (l1, l2) -> l1.get(0).compareTo( l2.get(0) ) );
        // System.out.println( sprinklers );
        
        int curr = 0, ON = 0, i = 0;
        int maxRange = 0;
        while ( curr < n )
        {
            if ( sprinklers.size()<=i || curr < sprinklers.get(i).get(0) )
                return -1;
            maxRange = sprinklers.get(i).get(1);
            while ( i<sprinklers.size()-1 && sprinklers.get(i+1).get(0) <= curr )
            {
                ++i;
                maxRange = Math.max(sprinklers.get(i).get(1) , maxRange);
            }
            if (maxRange < curr)
                return -1;
            ++ON;       ++i;
            curr = maxRange+1;
        }
        return ON;
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Pika-Wiggles-aoydQ5HRJUAbm.gif" width="135"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/410d51d667ab93f2219b15126f001f32e8bb029e/1/?track=30-DOC-day-28&batchId=320" align="left">706083</a>🖱</p>
<!--
#GURU ツ
-->
