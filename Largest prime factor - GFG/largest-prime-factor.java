//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
           long n=N;
        ArrayList <Long>ans=new ArrayList<>();
         long i;
        for( i=2;i*i<=n;++i){
            while(n%i==0){
                ans.add(i);
                n/=i;
            }
        }if (n>1)ans.add(n);
        return Collections.max(ans);
    }
}