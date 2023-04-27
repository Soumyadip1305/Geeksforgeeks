//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        BigInteger x = factorial(2 * n);
        BigInteger y = factorial(n + 1).multiply(factorial(n));
        return x.divide(y);
    }


    public static BigInteger factorial(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(-1));
        return factorialUtil(n, dp);
    }

    private static BigInteger factorialUtil(int n, BigInteger[] dp) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (!dp[n].equals(BigInteger.valueOf(-1))){
            return dp[n];
        }
           return dp[n] = BigInteger.valueOf(n).multiply(factorialUtil(n - 1, dp));
    }
}