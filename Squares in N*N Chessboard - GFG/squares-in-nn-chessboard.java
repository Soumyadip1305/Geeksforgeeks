//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.squaresInChessBoard(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long squaresInChessBoard(Long N) {
         long ans=0;
        for (int i = 1; i <=N ; i++) {
            ans+=binMultiply(i,i);
        }return ans;
    }
    private static long binMultiply(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) != 0) {
                ans = (ans + a) ;
            }
            a = (a + a) ;
            b = b >> 1;
        }
        return ans;
    }
}