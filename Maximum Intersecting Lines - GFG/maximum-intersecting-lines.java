//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public  int maxIntersections(int[][] lines, int N) {
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            starts[i] = lines[i][0];
            ends[i] = lines[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        Queue<Integer> qu = new LinkedList<Integer>();
        int ans=0;
        for (int i = 0; i < N; i++) {
            qu.add(ends[i]);
            if (qu.peek()<starts[i]){
                qu.remove();
            }
            ans=Math.max(ans,qu.size());
        }
        return ans;
    }
}
