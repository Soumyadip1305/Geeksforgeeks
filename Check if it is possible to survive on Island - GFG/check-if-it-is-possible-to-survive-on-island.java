//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int s, int n, int m){
          if (m > n) return -1;
        int totalFood = s * m;
        int sunday = s / 7;
        int buyFood = s - sunday;
        int ans = 0;
        if (totalFood % n == 0) ans = totalFood / n;
        else  ans=totalFood/n+1;
        if (ans<=buyFood)return ans;
        return -1;
    }
}