//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
            public static int findCatalan(int n) {
    if (n <= 1) {
                return 1;
            }

            int mod = (int) 1e9 + 7;
            int[] catalan = new int[n + 1];
            catalan[0] = catalan[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    catalan[i] = (catalan[i] + (int)((long)catalan[j] * catalan[i - j - 1] % mod)) % mod;
                }
            }

            return catalan[n];
        }
        }