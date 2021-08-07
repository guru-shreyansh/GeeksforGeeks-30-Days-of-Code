import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n, k, ans;
            n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = sc.nextInt();
            k = sc.nextInt();
            Solution obj = new Solution();
            ans = obj.find_min(a, n, k);
            System.out.println(ans);
            t--;
        }
    }
}

class Solution
{
    public int find_min(int[] a, int n, int k)
    {
        int sum = 0, complete_pairs = 0;
        for (int i = 0; i < n; i++)
        {
            // complete_pairs should hold the value of max pairs that can be picked from the drawer
            complete_pairs += a[i] / 2;

            // sum holds the value of maximum pairs that can be picked without exhausting any colour
            if (a[i] % 2 == 0)
                sum += (a[i] - 2) / 2;
            else
                sum += (a[i] - 1) / 2;
        }
        // returning -1 if required pairs is more than available pairs
        if (k > complete_pairs) return -1;

        // if k is lesser than or equal to sum, worst case after picking k-1 pairs is 2*(k-1) socks representing k-1 pairs
        // along with n socks, each of different colour one more pick after this will certainly complete kth pair
        if (k <= sum) return 2 * (k - 1) + n + 1;

        // if however, k>sum, the worst case is as described below 'sum' pairs are picked without exhausting any colour (2*sum picks)
        // n socks are picked, all of different colours (n picks) now, no colour has more than one sock left in drawer
        // this implies, each new pick will complete a pair therefore (k-sum) more picks required
        return 2 * sum + n + (k - sum);
    }
}
