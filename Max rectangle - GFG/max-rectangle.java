//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
   public static int maxArea(int[][] mat, int n, int m) {
        int[] currRow = new int[m];
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    currRow[j] += 1;
                } else {
                    currRow[j] = 0;
                }
            }
            maxAns = Math.max(maxAns, largestRectangleArea(currRow));
        }
        return maxAns;
    }

    public static int largestRectangleArea(int[] height) {
        int n=height.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                leftSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        /* Clear stack to reuse  */
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmaller[i] =n;
            } else {
                rightSmaller[i] = stack.peek();
            }

            stack.push(i);
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, (rightSmaller[i] - leftSmaller[i] - 1) * height[i]);
        }

        return maxi;
    }
}