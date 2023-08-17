//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {


         public static boolean isGreater(Vector<Integer> arr, int[] num, int n) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) < num[i]) return false;
            if (arr.get(i) > num[i]) return true;
        }
        return false;
    }

    public static Vector<Integer> generateNextPalindrome(int[] num, int n) {
        Vector<Integer> ans = new Vector<>();

        // Initialize the new Vector with zeros
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }

        int l = 0, r = n - 1;
        while (r > l) {
            ans.set(r, num[l]);
            ans.set(l, num[l]);
            l++;
            r--;
        }
        if (r == l) {
            ans.set(r, num[r]);
        }
        if (isGreater(ans, num, n)) return ans;

        int carry = 1;
        if (n % 2 == 1) {
            ans.set(r, ans.get(r) + 1);
            if (ans.get(r) < 10) return ans;
            ans.set(r, 0);
            carry = 1;
            r--;
            l++;
        }
        while (r >= 0) {
            ans.set(r, ans.get(r) + carry);
            ans.set(l, ans.get(l) + carry);
            if (ans.get(r) < 10) return ans;
            ans.set(r, 0);
            ans.set(l, 0);
            carry = 1;
            r--;
            l++;
        }
        if (carry == 1) {
            ans.add(0, 1);
            ans.set(ans.size() - 1, 1);
        }
        return ans;
    }
}