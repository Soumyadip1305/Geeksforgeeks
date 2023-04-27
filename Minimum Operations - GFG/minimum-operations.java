//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
       int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);
        return solve(n, dp);   
    }
         static int solve(int n, int[] dp) {
        if (n < 1) {
            return  Integer.MAX_VALUE;
        } else if (n == 1) {
            return 1;
        } else if (dp[n] != -1) {
            return dp[n];
        } else if (n % 2 == 0) {
            return dp[n] = 1 + solve(n / 2, dp);
        } else {
            return dp[n] =1+solve(n-1,dp);
    }
}
}