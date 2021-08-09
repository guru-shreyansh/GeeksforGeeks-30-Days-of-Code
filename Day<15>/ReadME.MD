<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Count Triplets</h1>

`Linked List`
`Mathematical`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C15%3E/D15.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 15</h3>
<blockquote>Given a sorted linked list of distinct nodes (no two nodes have the same data) and an integer X. Count distinct triplets in the list that sum up to given integer X.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;LinkedList: 1->2->4->5->6->8->9<br>
&emsp;&emsp;X = 17<br>
&emsp;&emsp;Output: 2<br>
&emsp;&emsp;Explanation: Distinct triplets are (2, 6, 9) and (4, 5, 8) which have sum equal to X i.e 17.<br>
* **Example 2**:<br>
&emsp;&emsp;LinkedList: 1->2->4->5->6->8->9,<br>
&emsp;&emsp;X = 15<br>
&emsp;&emsp;Output: 5<br>
&emsp;&emsp;Explanation: (1, 5, 9), (1, 6, 8), (2, 4, 9), (2, 5, 8), (4, 5, 6) are the distinct triplets.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function countTriplets() which takes a head reference and X as input parameters and returns the triplet count.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N²)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` Number of Nodes ` ≤  10³<br>
1  ≤ ` Node Value ` ≤  10⁴

###      ∑ HINTS ▸
- [x] _Think how hashing will work here!_
```java
    static int countTriplets(Node head, int x) 
    {
        int triplets = 0;
        Node firstPtr = head;
		HashSet<Integer> visited = new HashSet<Integer>();

		while (firstPtr != null)
		{
			Node secondPtr = firstPtr.next;
			while (secondPtr != null)
			{
				if ( visited.contains(x - (firstPtr.data + secondPtr.data)) )
					++triplets;

				secondPtr = secondPtr.next;
			}

			visited.add(firstPtr.data);
			firstPtr = firstPtr.next;
		}
		return triplets;
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"><b>Problem ID: </b><a href="https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1/?track=30-DOC-day-15&batchId=320" align="left">706071</a>🖱</p>
<!--
#GURU ツ
-->
