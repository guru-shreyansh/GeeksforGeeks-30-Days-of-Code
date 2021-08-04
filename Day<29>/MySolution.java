import java.io.*;
import java.util.*;

class GURU
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            String str = sc.next();
                 
            Sol obj = new Sol();
            System.out.println(obj.maxFrequency(str));
        }
    }
}

class Sol
{
    int maxFrequency(String S)
    {
        String prefix = "", suffix = "";
        int N = S.length();
        int start = 0, end = N-1;
        int maxFreq = 1;
        int freq = 0;
        
        while ( start <= end )
        {
            prefix = S.substring(0 , start+1);  // prefix + C[start];
            suffix = S.substring(end);          // C[end] + suffix;
            if ( prefix.equals(suffix) )
            {
                freq = ( N - S.replaceAll(prefix,"").length() ) / prefix.length();
                if ( freq < maxFreq )           // If new Frequency is < Max Frequency
                    return maxFreq;                 // found so far we can't get
                maxFreq = Math.max( freq , maxFreq );   // a higher count
            }
            --end;
            ++start;
        }
        return maxFreq;
    }
}
