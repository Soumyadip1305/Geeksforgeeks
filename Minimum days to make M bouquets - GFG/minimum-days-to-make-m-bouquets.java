//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int solve(int m, int k, int[] bloomDay) {
        int maxi=0,min=Integer.MAX_VALUE;
        for (int num : bloomDay) {
            maxi = Math.max(maxi, num);
            min = Math.min(min, num);
        }
        int low = min;
        int high =maxi;
        long x=((long) m *k);
        if(x>bloomDay.length)return -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean possible(int[] arr, int day, int m, int k) {
        int ct = 0, num_of_bouquet = 0;
        for (int num : arr) {
            if (num <= day) {
                ct++;
            } else {
                num_of_bouquet += (ct / k);
                ct = 0;
            }
        }
        num_of_bouquet += (ct / k);
        return num_of_bouquet >= m;
    }
}