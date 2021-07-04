<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%232.png" width="100">
<h1>:people_holding_hands: Help Classmates</h1>

`Stack`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C17%3E/D17.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 17</h3>
<blockquote>Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
Note: one student may be selected by multiple classmates.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 5<br>
&emsp;&emsp;arr[ ] = {3, 8, 5, 2, 25}<br>
&emsp;&emsp;Output: 2 5 2 -1 -1<br>
&emsp;&emsp;Explanation: 1. Roll number 1 has 3 marks. The first person who has less marks than him is roll number 4, who has 2 marks.
2. Roll number 2 has 8 marks, he helps student with 5 marks.
3. Roll number 3 has 5 marks, he helps student with 2 marks.
4. Roll number 4 and 5 can not pick anyone as no student with higher roll number has lesser marks than them. This is denoted by -1.
Output shows the marks of the weaker student that each roll number helps in order. ie- 2,5,2,-1,-1<br>
* **Example 2**:<br>
&emsp;&emsp;N = 4<br>
&emsp;&emsp;a[ ] = {1, 2, 3, 4}<br>
&emsp;&emsp;Output: -1 -1 -1 -1<br>
&emsp;&emsp;Explanation: As the marks ars in increasing order. None of the students can find a classmate who has a higher roll number and less marks than them.<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function help_classmate() which takes the array arr[] and size of array N as input parameters and returns a list of numbers. If a student is unable to find anyone then output is -1.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(N)</td> <td align="center">O(N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` N ` ≤  10⁶<br>
0  ≤ ` a[i] ` ≤  N-1

###      ∑ HINTS ▸
- [x] _Use a stack to compare elements. Loop through the contents of the given array and compare it to the top of stack. If top of stack is bigger than current element that means that current element is the next smallest element for the element in the stack. If not, add the current element to the stack._
- [x] _To maintain the order of the given array, store the index of elements in the stack instead of the value._
```java
    public static int[] help_classmate(int arr[], int n) 
	{
	    int j=1;
	    int[] help = new int[n];
	    for (int i=0; i<n; i++)
	    {
	        j = i+1;
	        while (j<n && arr[i] <= arr[j])
	            ++j;
	        if (j != n)
	            help[i] = arr[j];
	        else 
	            help[i] = -1;
	    }
	    return help;
	}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Happy-Powerpuff-Girls-Qakyyrk1IKwuK8YtQ6.gif" width="75"> </p>
<!--
#GURU ツ
-->
