<img align='right' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/Medium%233.png" width="100">
<h1>:people_holding_hands: Spidey Sense</h1>

`BFS`
`Queue`
`Graph`
<img align='centre' src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/Day%3C25%3E/D25.png">
________________________________________________________________________________________________________________________________________________________
<h3>:heavy_check_mark: Day 25</h3>
<blockquote>Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters ‘O’, ‘B’, and ‘W’ where: 
‘O’ represents an open space.
‘B’ represents a bomb.
‘W’ represents a wall.
You have to replace all of the O’s (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.</blockquote>

* **Example 1**:<br>
&emsp;&emsp;N = 3, M = 3<br>
&emsp;&emsp;A[] = {{O, O, O}, 
       {W, B, B}, 
       {W, O, O}}<br>
&emsp;&emsp;Output: {{2, 1, 1}, 
         {-1, 0, 0},  
         {-1, 1, 1}}<br>
&emsp;&emsp;Explanation: The walls at (1,0) and (2,0) are replaced by -1. The bombs at (1,1) and (1,2) are replaced by 0. The impact zone for the bomb at (1,1) includes open spaces at index (0,0), (0,1) and (2,1) with distance from bomb calculated as 2,1,1 respectively. The impact zone for the bomb at (1,2) 
includes open spaces at index (0,3) and (2,2) with distance from bomb calculated as 1,1 respectively.<br>
* **Example 2**:<br>
&emsp;&emsp;N = 2, M = 2<br>
&emsp;&emsp;A[] = {{O, O},
       {O, O}}<br>
&emsp;&emsp;Output: {{-1, -1}
         {-1, -1}<br>
&emsp;&emsp;Explanation: NaN<br>

**➔ Your Task**:
<mark>You don't need to read input or print anything. Complete the function findDistance() which takes the matrix A[], M, and N as input parameters and the resultant matrix.</mark>

<table align="center">
      <tr><td><em><b>Expected Time Complexity</td> <td><em><b>Expected Auxiliary Space</td></tr>
      <tr><td align="center">O(M*N)</td> <td align="center">O(M*N)</td></tr>
</table>

#### < Constraints >
1  ≤ ` M*N ` ≤  10⁶<br>

###      ∑ HINTS ▸
- [x] _Think in terms of BFS algorithm. Take help of a queue._
```java
class Solution
{
    static int[][] findDistance(char matrix[][], int M, int N)
    {
        int[][] result = new int[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (matrix[i][j] == 'B')
                    update(result, matrix, i, j, 0, M, N);

        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (result[i][j] == 0)
                    result[i][j] = -1;
                if (matrix[i][j] == 'B')
                    result[i][j] = 0;
                if (matrix[i][j] == 'W')
                    result[i][j] = -1;
            }
        }
        return result;
    }

    static void update(int[][] result, char[][] matrix, int i, int j, int payload, int M, int N)
    {
        if (isValid(matrix, i, j, M, N) || payload == 0)
        {
            if (result[i][j] == 0 || result[i][j] > payload)
            {
                result[i][j] = payload;
                update(result, matrix, i - 1, j, payload + 1, M, N);
                update(result, matrix, i, j + 1, payload + 1, M, N);
                update(result, matrix, i + 1, j, payload + 1, M, N);
                update(result, matrix, i, j - 1, payload + 1, M, N);
            }
        }
    }

    static boolean isValid(char[][] matrix, int i, int j, int M, int N)
    {
        return (0 <= i && 0 <= j && i < M && j < N && matrix[i][j] == 'O');
    }
}
@author : Shreyansh Kumar Singh
```
<p align="right"> ⭐️ <a href="https://github.com/GURU-Shreyansh" target="_blank"> <b>GURU-Shreyansh</b></a>
      <img src="https://github.com/guru-shreyansh/GeeksforGeeks-30-Days-of-Code/blob/main/!DOC!/GIF--Pika-Wiggles-aoydQ5HRJUAbm.gif" width="135"> </p>
<!--
#GURU ツ
-->
