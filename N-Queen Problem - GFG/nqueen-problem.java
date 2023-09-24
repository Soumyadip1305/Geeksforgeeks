//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

        queens(grid, 0, ans);
        return ans;
    }

    static void queens(boolean[][] grid, int r, ArrayList<ArrayList<Integer>> ans) {
        if (r == grid.length) {
            ans.add(new ArrayList<>(display(grid)));
        }
        for (int c = 0; c < grid.length; c++) {
            if (isSafe(grid, r, c)) {
                grid[r][c] = true;  //mark as visited
                queens(grid, r + 1, ans);
                grid[r][c] = false;  // backtrack
            }
        }
    }

    private static boolean isSafe(boolean[][] grid, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (grid[i][c]) {
                return false;
            }
        }
        // Check Diagonal Right check
        int maxR = Math.min(grid.length - c - 1, r);
        for (int i = 1; i <= maxR; i++) {
            if (grid[r - i][c + i]) {
                return false;
            }
        }
        // Check Diagonal Left check
        int maxL = Math.min(r, c);
        for (int i = 1; i <= maxL; i++) {
            if (grid[r - i][c - i]) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> display(boolean[][] board) {
        ArrayList<Integer> list = new ArrayList<>();

        for (boolean[] booleans : board) {
            for (int j = 0; j < booleans.length; j++) {
                if (booleans[j]) {
                    list.add(j + 1);
                }
            }
        }
        return list;
    }
}
