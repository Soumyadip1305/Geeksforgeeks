//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static double findSmallestMaxDist(int arr[],int K) {
   double low = 0;
        double high = 0;
        for (int i = 0; i < arr.length-1; i++) {
            high=Math.max(high,(double) (arr[i+1]-arr[i]));
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2;
            int cnt = Number_Of_Gas_Station_Requiring(mid, arr);
            if (cnt > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    static int Number_Of_Gas_Station_Requiring(double dist, int[] arr) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);

            if (((arr[i] - arr[i - 1]) / dist) == numberInBetween + dist) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
}