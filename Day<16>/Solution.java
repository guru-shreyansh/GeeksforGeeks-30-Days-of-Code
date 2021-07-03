import java.util.*;
import java.math.*;

class GfG
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
        if (k == 1)
        {
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int ctr = 0;
        for (int i=0; i<l; i++)
        {
            if (st.size() == 0)
            {
                st.push(new Pair(s.charAt(i),1));
                continue;
            }
            if (st.peek().c == s.charAt(i))
            {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if(p.ctr == k)
                {
                    continue;
                }
                else
                {
                    st.push(p);
                }
            }
            else
            {
                 st.push(new Pair(s.charAt(i),1));
            }
        }
        String ans = "";
        while (st.size() > 0)
        {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while (cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        return ans;
    }
}
class Pair
{
    char c;
    int ctr;
    Pair(char c,int ctr)
    {
        this.c = c;
        this.ctr = ctr;
    }
}
