<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Lucy's Neighbours</h1>

`Heap`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C23%3E/D23.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 23</h3>
<blockquote>Lucy lives in house number X. She has a list of N house numbers in the society. Distance between houses can be determined by studying the difference between house numbers. Help her find out K closest neighbors.
<b>Note:</b> If two houses are equidistant and Lucy has to pick only one, the house with the smaller house number is given preference.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 5, X = 0, K = 4<br>
&emsp;&emsp;a[ ] = {-21, 21, 4, -12, 20}<br>
&emsp;&emsp;Output: -21 -12 4 20<br>
&emsp;&emsp;Explanation: The closest neighbour is house number 4. Followed by -12 and 20. -21 and 21 are both equal distance from X=0. Therefore, Lucy can only pick 1. Based on the given condition she picks -21 as it is the smaller of the two.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 6, X = 5, K = 3<br>
&emsp;&emsp;a[ ] = {10, 2, 14, 4, 7, 6}<br>
&emsp;&emsp;Output: 4 6 7<br>
&emsp;&emsp;Explanation: NaN<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function  Kclosest() which takes the array arr[], size of array N, X, and K as input parameters, and returns the list of numbers in sorted order.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N*log(N))</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` K ` , ` N ` ≤  10⁵<br>
-10⁴  ≤ ` X ` , ` arr[i] ` ≤  10⁴

###      ∑ HINTS ▸
- [x] _Make a max heap of k houses with custom Compare function that firstly gives priority to maximum distance but if the two distances are same then priority is given to house with greater house number._
- [ ] _1) Make a max heap with first k elements._
- [ ] _2) For every element from (k+1)th to nth, do the following._
- [ ] _…..a) Find difference of current element with x._
- [ ] _…..b) If difference is more than root of heap, ignore current element._
- [ ] _…..c) Else insert the current element to the heap after removing the root._
- [ ] _3) Finally the heap has k closest elements._
```java
    public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i=0; i<n; i++)
		{
		    List<Integer> row = new ArrayList<Integer>();
		    row.add( Math.abs(arr[i]-x) );
		    row.add( arr[i] );
		    list.add(row);
		}
		list.sort( (l1, l2) -> l1.get(0).compareTo( l2.get(0) ) );
		
		List<Integer> last = List.of(100000000, 100000000);
		list.add( last );
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=0; i<k; i++)
		{
		    if ( list.get(i).get(0)==list.get(i+1).get(0) )
		    {
		        ArrayList<Integer> row = new ArrayList<Integer>();
		        row.add( list.get(i).get(1) );
		        while ( list.get(i).get(0)==list.get(i+1).get(0) )
		        {
		            row.add( list.get(i+1).get(1) );    ++i;
		        }
		        Collections.sort( row );
		        result.addAll(row);
		        continue;
		    }
		    result.add( list.get(i).get(1) );
		}
		Collections.sort( result );
		for (int i=k; i<result.size(); i++)
		    result.remove(i);
		return result;
	}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Pika-Wiggles-aoydQ5HRJUAbm.gif" width="135"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/20b8ec4db3f8da0697acdd3d54d9af9f76405443/1/?track=30-DOC-day-23&batchId=320" align="left">706079</a>🖱</p>
<!--
#GURU ツ
-->
