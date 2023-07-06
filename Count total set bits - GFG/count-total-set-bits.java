//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
       int cnt = 0;
        for(int i = 1;i<=100000000;i=i<<1)
            cnt += (i*(n/(i*2))) + Math.max(0, n%(i*2) - (i-1));

        return cnt;
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends