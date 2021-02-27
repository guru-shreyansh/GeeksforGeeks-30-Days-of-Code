<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Hard%231.png" width="100">
<h1>:people_holding_hands: Number of minimum picks to get 'k' pairs of socks from a drawer</h1>

`Arrays`
`Probability`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C04%3E/D04.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 4</h3>
<blockquote>A drawer contains socks of n different colours. The number of socks available of ith colour is given by a[i] where a is an array of n elements. Tony wants to take k pairs of socks out of the drawer. However, he cannot see the colour of the sock that he is picking. You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that he can be absolutely sure, without seeing their colours, that he will have at least k matching pairs.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 4, K = 6<br>
&emsp;&emsp;a[ ] = {3, 4, 5, 3}<br>
&emsp;&emsp;Output: 15<br>
&emsp;&emsp;Explanation: All 15 socks have to be picked in order to obtain 6 pairs.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 2, K = 3<br>
&emsp;&emsp;a[ ] = {4, 6}<br>
&emsp;&emsp;Output: 7<br>
&emsp;&emsp;Explanation: The Worst case scenario after 6 picks can be {3,3} or {1,5} of each coloured socks. Hence 7th pick will ensure 3rd pair.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function find_min() which takes the array a[], size of array N, and value K as input parameters and returns the minimum number of socks Tony has to pick. If it is not possible to pick then return -1.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
1  ≤ ` a[i] ` ≤  10⁶

###      ∑ HINTS ▸
- [x] _Count the maximum number of pairs that can be formed._
```java
public int find_min(int[] a, int n, int k)
{
    if ( n==1 && 2*k<=a[0] ) return 2*k;
    else if ( n==1 && 2*k>a[0] ) return -1;
    int maxPossiblePairs = 0;
    int picks = n;
    ArrayList<Integer> odd = new ArrayList<Integer>();
    ArrayList<Integer> even = new ArrayList<Integer>();
    ArrayList<Integer> rest = new ArrayList<Integer>();
    for (int i=0; i<n; i++)
    {
        maxPossiblePairs += a[i]/2;
        --a[i];
        if ( a[i]%2 == 0 )
            even.add( a[i] );
        else 
            odd.add( a[i] );
    }
    if ( maxPossiblePairs < k )
        return -1;
        
    Collections.sort(even, Collections.reverseOrder());
    Collections.sort(odd, Collections.reverseOrder());
    int i = 0;
    for (i=0; i<even.size() && 0<k; i++)
    {
        if ( even.get(i) < 2*k )
        {
            picks += even.get(i);
            k -= even.get(i)/2;
        }
        else if ( 2*k <= even.get(i) )
        {
            picks += 2*k-1;
            k -= k;
        }
        // System.out.println("Even -> k= "+k+" picks= "+picks);
    }
    for (i=0; i<odd.size() && 0<k; i++)
    {
        if ( odd.get(i) < 2*k )
        {
            picks += odd.get(i)-1;
            k -= (odd.get(i)-1)/2;
            rest.add(1);
        }
        else if ( 2*k <= odd.get(i) )
        {
            picks += 2*k-1;
            k -= k;
        }
    }
    i=0;
    while ( 0 < k && i<rest.size() )
    {
        k-=rest.get(i);
        picks+=rest.get(i);
        ++i;
    }
    // System.out.println("maxPossPair = "+maxPossiblePairs+" k = "+k+" picks = "+picks);
    if ( 0<k )
        return -1;
    
    return picks;
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Shinchan-vIxKKPtpfnL1K.gif" width="75"> </p>
<!--
#GURU ツ
-->
