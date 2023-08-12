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
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String s) {
       int openingBr = 0, closingBr = 0, maxi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openingBr++;
            } else {
                closingBr++;
            }
            if (openingBr == closingBr) {
                maxi = Math.max(maxi, openingBr * 2);
            } else if (closingBr > openingBr) {
                openingBr = 0;
                closingBr = 0;
            }
        }
        openingBr=0;
        closingBr=0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == '(') {
                openingBr++;
            } else {
                closingBr++;
            }
            if (openingBr == closingBr) {
                maxi = Math.max(maxi, openingBr * 2);
            } else if (openingBr > closingBr) {
                openingBr = 0;
                closingBr = 0;
            }
        }
        return maxi;
    }
}