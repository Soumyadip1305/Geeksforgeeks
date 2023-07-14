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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int[] ptr = ob.getPrimes(N);

            System.out.println(ptr[0] + " " + ptr[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] getPrimes(int N) {
            int []arr=new int[2];
        Arrays.fill(arr,-1);
        for (int i = 1; i <=N ; i++) {
             if (is_prime(i)&&is_prime(N-i)){
                    arr[0]=i;
                    arr[1]=N-i;
                    break;
            }
        }return arr;
    }
    private static boolean is_prime(long n) {
        if (n == 1||n==0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}