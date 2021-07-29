import java.util.*;
import java.math.*;
class Pair
{
    int x,y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class GURU
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while (t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for (int i=0; i<m; i++)
            {
                for (int j=0; j<n; j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0; i<m; i++)
            {
                for (int j=0; j<n; j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

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
