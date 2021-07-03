import java.util.*;
import java.math.*;

class GURU
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while (t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            System.out.println(T.reduced_String(k, s));
        }
    }
}

class Solution
{
    public static String reduced_String(int k, String s)
    {
        if (k==1) return "";
        StringBuilder output = new StringBuilder(s);
        int count[] = new int[output.length()];

        for (int i=0; i<output.length(); i++)
        {
            if ( i==0 || output.charAt(i) != output.charAt(i-1) )
                count[i] = 1;
            else
            {
                count[i] = count[i-1] + 1;
                if (count[i]==k)
                {
                    output.delete(i-k+1,i+1);
                    i = i-k;
                }
            }
        }
        return output.toString();
    }
}
