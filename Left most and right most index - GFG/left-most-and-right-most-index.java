//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
          if (lowerBound(v,v.length,x)==v.length||v[lowerBound(v,v.length,x)]!=x) return new pair(-1,-1);
        return new pair(lowerBound(v,v.length,x),upperBound(v,v.length,x));
    }
    private static int lowerBound(long[] arr, int n, long x) {
        int low=0;
        int high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]>=x){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }return low;
    }
    private static int upperBound(long[] arr, int n, long x) {
        int low=0;
        int high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]>x){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }return high;
    }
}