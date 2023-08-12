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
    public int maxArea(int M[][], int n, int m) {
       int[] currRow = new int[m];
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    currRow[j] += 1;
                } else {
                    currRow[j] = 0;
                }
            }
            maxAns = Math.max(maxAns, largestRectangleArea(currRow));
        }
        return maxAns;
    }

    public static int largestRectangleArea(int[] hist) {
        int[] left = new int[hist.length];
        Stack<Integer> st1 = new Stack<>();
        int[] right = new int[hist.length];
        Stack<Integer> st2 = new Stack<>();

        for (int i = 0; i < hist.length; i++) {
            while (!st1.isEmpty() && hist[i] <= hist[st1.peek()]) {
                st1.pop();
            }
            if (st1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st1.peek();
            }
            st1.push(i);
        }

        for (int i = hist.length - 1; i >= 0; i--) {
            while (!st2.isEmpty() && hist[i] <= hist[st2.peek()]) {
                st2.pop();
            }
            if (st2.isEmpty()) {
                right[i] = hist.length;
            } else {
                right[i] = st2.peek();
            }
            st2.push(i);
        }

        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < hist.length; i++) {
            int area = (right[i] - left[i] - 1) * hist[i];
            max_area = Math.max(max_area, area);
        }

        return max_area;

    }
}