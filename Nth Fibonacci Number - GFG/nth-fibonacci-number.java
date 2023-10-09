//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int mod=1000000007;
    static int nthFibonacci(int n){
          //  int[] dp = new int[n + 1];
        //  Arrays.fill(dp, -1);
        //   System.out.println(nthFibo(n,dp));
        //  System.out.println(nthFibo2(n));
        return nthFibo3(n);
    }


    static int nthFibo(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) return dp[n];
        return dp[n] = nthFibo(n - 1, dp) + nthFibo(n - 2, dp);
    }

    static int nthFibo2(int n) {  //   Tabulation
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int nthFibo3(int n) {  //   Remove dp array
        if (n == 0) return 0;
        int prev = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            int currI = (prev + prev2)%mod;
            prev2 = prev;
            prev = currI;
        }
        return  prev;
    }
}