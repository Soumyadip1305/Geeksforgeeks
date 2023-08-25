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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
            char[] arr = S.toCharArray();
        return is_Palindrome(arr, 0) ? 1 : 0;
        // return is_Palindrome(S, 0, S.length() - 1) ? 1 : 0;
    }

    static boolean is_Palindrome(char[] s, int i) {
        if (i > s.length / 2) return true;
        if (s[i] != s[s.length - i - 1]) return false;
        return is_Palindrome(s, i + 1);
    }
}