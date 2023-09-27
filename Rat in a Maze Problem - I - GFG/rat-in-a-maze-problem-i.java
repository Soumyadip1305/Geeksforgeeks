//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
         ArrayList<String> list = new ArrayList<>();
        int[][] vis = new int[n][n];
        if (m[0][0] == 0) {
            return list;
        }
        if (m[n - 1][n - 1] == 0) {
            return list;
        }

        String s = "";
        solve(0, 0, s, m, n, vis, list);
        Collections.sort(list);
        return list;
    }

    private static void solve(int r, int c, String s, int[][] m, int n, int[][] vis, ArrayList<String> list) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return;
        }
        if (m[r][c] == 0 || vis[r][c] == 1) {
            return;
        }
        if (r == n - 1 && c == n - 1) {
            list.add(s);
            return;
        }
        vis[r][c] = 1;

        solve(r - 1, c, s + "U", m, n, vis, list);
        solve(r + 1, c, s + "D", m, n, vis, list);
        solve(r, c - 1, s + "L", m, n, vis, list);
        solve(r, c + 1, s + "R", m, n, vis, list);

        vis[r][c] = 0;

    }
}