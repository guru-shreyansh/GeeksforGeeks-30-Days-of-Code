import java.io.*;
import java.util.*;

class GURU
{
    public static void main(String args[]) throws IOException
    { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0)
		{
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    }
}

class Solution
{
    static int repeatedStringMatch(String A, String B)
    {
        if ( A.indexOf(B) != -1 )
            return 1;
	    
        StringBuilder aaa = new StringBuilder("");
        StringBuilder bbb = new StringBuilder("");
	    
        int length = B.length()+A.length();
        int repeated = 0;
	    
        while ( (aaa.indexOf(B) == -1) && (aaa.length() < length) )
        {
            aaa.append(A);
            ++repeated;
        }
	    
        if ( aaa.indexOf(B) == -1 )
            return -1;
        return repeated;
    }
}
