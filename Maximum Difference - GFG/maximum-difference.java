//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int arr[], int n)
    {
	 Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        leftSmaller[0] = 0;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) leftSmaller[i] = 0;
            else leftSmaller[i] = arr[stack.peek()];
            stack.push(i);
        }
        /* Clear stack to reuse  */
        stack.clear();
        rightSmaller[n - 1] = 0;
        stack.push(n-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            }
            else {
                rightSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        int maxi=0;
        for (int i = 0; i < n; i++) {
            maxi=Math.max(Math.abs(leftSmaller[i]-rightSmaller[i]),maxi);
        }
        return maxi;
    }
}