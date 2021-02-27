import java.io.*;
import java.util.*;
class GFG {
     public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.candies(m,n));
            t--;
        }
    } 
}// } Driver Code Ends

class Solution
{
    static int candies(int m, int n)
    {                               // Any number >= "LCM(m,n)-m-n" can be formed
        return (m-1)*(n-1)/2;       // So we only need to check for numbers less
    }                               //      than or equal to (mn - m - n)
}
