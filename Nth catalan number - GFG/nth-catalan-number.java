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


    private static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        BigInteger result=BigInteger.valueOf(n);
        return result.multiply(factorial(n-1));
    }
}