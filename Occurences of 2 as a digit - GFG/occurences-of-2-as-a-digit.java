//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            GfG gfg = new GfG();
            long res = gfg.count2s(n);
            System.out.println(res);
        }
        
    }
}

// } Driver Code Ends


class GfG
{
      public static long count2s(long n) {
        long ct = 0;
        for (long i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '2') ct++;
            }
        }
        return ct;
    }

    public static long count2sinRangeAtDigit(long n, long d) {
        long ct = 0;

        for (long i = d; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '2') ct++;
            }
        }
            return ct;
        }
}