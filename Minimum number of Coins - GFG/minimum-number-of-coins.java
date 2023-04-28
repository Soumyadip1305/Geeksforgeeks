//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
         List<Integer> rupees = new ArrayList<>();
        rupees.add(1);
        rupees.add(2);
        rupees.add(5);
        rupees.add(10);
        rupees.add(20);
        rupees.add(50);
        rupees.add(100);
        rupees.add(200);
        rupees.add(500);
        rupees.add(2000);
        return solve(N, rupees);
        
    }
    static List<Integer> solve(int n, List<Integer> rupees) {
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int d : rupees) {
            for (int i = d; i <= n; i++) {
                if (dp[i-d] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-d] + 1);
                }
            }
        }
        return buildCoinsList(n, dp, rupees);
    }
    
        static List<Integer> buildCoinsList(int n, int[] dp, List<Integer> rupees) {
        List<Integer> coins = new ArrayList<>();
        while (n > 0) {
            for (int d : rupees) {
                if (n >= d && dp[n] == dp[n-d] + 1) {
                    coins.add(d);
                    n -= d;
                    break;
                }
            }
        }
        Collections.reverse(coins);
        return coins;
    }

}