//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int nextHappy(int N) {
        return solve(N+1);
    }
    static int solve(int N){
        if (isHappy(N)) {
            return N;
        }
        return solve(N + 1);
    }
    static boolean isHappy(int n){
        HashMap<Integer, Integer> map = new HashMap<>();


        while (!map.containsKey(n)) {
            map.put(n, 1);

            int sum = 0;
            while (n > 0) {
                int a = n % 10;

                sum += a * a;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}