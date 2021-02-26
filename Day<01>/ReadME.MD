<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Easy%231.png" width="100">
<h1>:people_holding_hands: Rearrange Geek and his Classmates</h1>

`List`
`Array`
`Vector`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/D01.png">
________________________________________________________________________________________________________________________________________________________
<h3>[✚] Day 1 :heavy_check_mark:</h3>
<blockquote>Geek and his classmates are playing a prank on their Computer Science teacher. They change places every time the teacher turns to look at the blackboard.
Each of the N students in the class can be identified by a unique roll number X and each desk has a number i associated with it. Only one student can sit on one desk. 
Each time the teacher turns her back, a student with roll number X sitting on desk number i gets up and takes the place of the student with roll number i.
If the current position of N students in the class is given to you in an array, such that i is the desk number and a[i] is the roll number of the student sitting on the desk, can you modify a[ ] to represent the next position of all the students ?</blockquote>

* Example 1:
&emsp;&emsp;N = 6
&emsp;&emsp;a[] = {0, 5, 1, 2, 4, 3}
&emsp;&emsp;Output: 0 3 5 1 4 2
&emsp;&emsp;Explanation: After reshuffling, the modified position of all the students would be {0, 3, 5, 1, 4, 2}.
* Example 2:
&emsp;&emsp;N = 5
&emsp;&emsp;a[] = {4, 3, 2, 1, 0}
&emsp;&emsp;Output: 0 1 2 3 4 
&emsp;&emsp;Explanation: After reshuffling, the modified position of all the students would be {0, 1, 2, 3, 4}.
