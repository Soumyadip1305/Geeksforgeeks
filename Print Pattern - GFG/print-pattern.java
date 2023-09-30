//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> pattern(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        solve(n, ans);
        return ans;
    }

    static void solve(int n, ArrayList<Integer> list) {
        list.add(n);
        if (n<=0)return;
        solve(n-5,list);
        list.add(n);
    }
}