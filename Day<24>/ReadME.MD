<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Easy%233.png" width="100">
<h1>:people_holding_hands: Gadgets of Doraland</h1>

`Hash`
`Heap`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C24%3E/D24.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 24</h3>
<blockquote>In Doraland, people have unique Identity Numbers called D-id. Doraemon owns the most popular gadget shop in Doraland. Since his gadgets are in high demand and he has only K gadgets left he has decided to sell his gadgets to his most frequent customers only. N customers visit his shop and D-id of each customer is given in an array array[ ]. In case two or more people have visited his shop the same number of time he gives priority to the customer with higher D-id. Find the D-ids of people he sells his K gadgets to.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 6, K = 2<br>
&emsp;&emsp;array[ ] = {1, 1, 1, 2, 2, 3}<br>
&emsp;&emsp;Output: 1 2<br>
&emsp;&emsp;Explanation: Customers with D-id 1 and 2 are most frequent.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 8, K = 2<br>
&emsp;&emsp;array[] = {1, 1, 2, 2, 3, 3, 3, 4}<br>
&emsp;&emsp;Output: 3 2<br>
&emsp;&emsp;Explanation: People with D-id 1 and 2 have visited shop 2 times Therefore, in this case, the answer includes the D-id 2 as 2 > 1.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function TopK() which takes array[ ] and integer K as input parameters and returns an array containing D-id of customers he has decided to sell his gadgets to.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` D-id ` ≤  10⁴

###      ∑ HINTS ▸
- [x] _Use hashing._
```java
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        Map<Integer, Integer> fMap = new HashMap<>();
        for (Integer num : array)
        {
            fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        }
        
        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b)
        -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
                                             : Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<Integer,Integer> key : fMap.entrySet())
        {
            heap.offer( key );
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<k; i++)
        {
            ans.add( heap.poll().getKey() );
        }
        
        return ans;
    }
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Pika-Wiggles-aoydQ5HRJUAbm.gif" width="135"> </p>
<!--
#GURU ツ
-->
