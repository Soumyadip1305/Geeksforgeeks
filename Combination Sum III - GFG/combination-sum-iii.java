//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int k, int n) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
       // func(0, k, n, new ArrayList<>(), arr, ans);
        combination(1, k, n, 0, new ArrayList<>(), ans);
        return ans;
    }

    static void combination(int ind, int k, int n, int sum, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans) {
        if (k == ds.size() && sum == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ds.size() >= k || sum >= n) {
            return;
        }
        //  Pick it up
        for (int i = ind; i <= 9; i++) {
            if (i > n) break;
            ds.add(i);
            combination(i + 1, k , n,sum+i, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    private static void func(int ind, int k, int sum, List<Integer> ds, int[] arr, List<List<Integer>> ans) {
        if (ind == arr.length) {
            if (ds.size() == k && sum == 0) ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[ind]);
        func(ind + 1, k, sum - arr[ind], ds, arr, ans);
        ds.remove(ds.size() - 1);
        func(ind + 1, k, sum, ds, arr, ans);
    }
}