//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java
class Solution{
   
      static boolean isPower(long n) {
        if (n == 0) {
            return false;
        }
        while (n > 1) {
            if (n % 5 != 0) {
                return false;
            }
            n /= 5;
        }
        return true;
    }

   static int f(long sum, int j, String s) {
        for (; j < s.length(); j++) {
            sum *= 2;
            sum += (s.charAt(j) == '1') ? 1 : 0;
            if (isPower(sum)) {
                int x = f(sum, j + 1, s);
                int y = 1 + f(0, j + 1, s);
                return Math.min(x, y);
            }
            if (sum == 0) {
                return 100;
            }
        }
        if (sum == 0) {
            return 0;
        }
        if (isPower(sum)) {
            return 1;
        }
        return 100;
    }

   static int cuts(String s) {
        int temp = f(0, 0, s);
        if (temp > 50) {
            return -1;
        }
        return temp;
    }
}
