//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
       Stack<Integer> stack = new Stack<>();
    int[] leftSmaller = new int[(int) n];
    int[] rightSmaller = new int[(int) n];
    
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) leftSmaller[i] = 0;
        else leftSmaller[i] = stack.peek() + 1;
        stack.push(i);
    }
    
    // Clear stack to reuse
    stack.clear();
    
    for (int i = (int) (n - 1); i >= 0; i--) {
        while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) rightSmaller[i] = (int) (n - 1);
        else rightSmaller[i] = stack.peek() - 1;
        stack.push(i);
    }
    
    long maxi = 0;
    for (int i = 0; i < n; i++) {
        maxi = Math.max(maxi, hist[i] * (rightSmaller[i] - leftSmaller[i] + 1));
    }
    
    return maxi;
}
}