//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] a, int n) {
         int ans[] = new int[n];
        int x = n - 2;
        List<Integer> arr = new ArrayList<>();
        arr.add(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int idx = solve(arr, a[i], 0, arr.size() - 1);
            arr.add(idx, a[i]);
            ans[x] = idx;
            x--;

        }
        return ans;

    }

    int solve(List<Integer> arr, int key, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= key) {
                return solve(arr, key, low, mid - 1);
            } else {
                return solve(arr, key, mid + 1, high);
            }
        }
        return low;
    }
}