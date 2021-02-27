<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Easy%231.png" width="120">
<h1>:people_holding_hands: Rearrange Geek and his Classmates</h1>

`List`
`Array`
`Vector`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/D01.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 1</h3>
<blockquote>Geek and his classmates are playing a prank on their Computer Science teacher. They change places every time the teacher turns to look at the blackboard.
Each of the N students in the class can be identified by a unique roll number X and each desk has a number i associated with it. Only one student can sit on one desk. 
Each time the teacher turns her back, a student with roll number X sitting on desk number i gets up and takes the place of the student with roll number i.
If the current position of N students in the class is given to you in an array, such that i is the desk number and a[i] is the roll number of the student sitting on the desk, can you modify a[ ] to represent the next position of all the students ?</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 6<br>
&emsp;&emsp;a[ ] = {0, 5, 1, 2, 4, 3}<br>
&emsp;&emsp;Output: 0 3 5 1 4 2<br>
&emsp;&emsp;Explanation: After reshuffling, the modified position of all the students would be {0, 3, 5, 1, 4, 2}.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;a[ ] = {4, 3, 2, 1, 0}<br>
&emsp;&emsp;Output: 0 1 2 3 4 <br>
&emsp;&emsp;Explanation: After reshuffling, the modified position of all the students would be {0, 1, 2, 3, 4}.<br>

**➔ Your Task**:
<mark>You dont need to read input or print anything. Complete the function prank() which takes the array a[ ] and its size N as input parameters and modifies the array in-place to reflect the new arrangement.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(1)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁵<br>
0  ≤ ` a[i] ` ≤  N-1

∑ <span>HINTS:</span>
- [x] _Use simple mathematics and modular arithmetic._
```java
void prank(long[] arr, int n)
{
      long temp = 0;
      long[] result = new long[n];
      for (int i=0; i<n; i++)
      {
          result[i] = arr[ (int)arr[i] ];
      }
      // System.out.println(Arrays.toString(result));
      System.arraycopy(result, 0, arr, 0, n);
}
@author : Shreyansh Kumar Singh
```
@guru_shreyansh
<!--
#GURU ツ
-->
