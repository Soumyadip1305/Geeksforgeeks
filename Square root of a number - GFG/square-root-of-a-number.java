//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		  if (x == 0 || x == 1) {
            return x;
        }
        long low = 1;
        long high = x;
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long temp = mid * mid;
            if (temp == x) {
                result = mid;
                break;
            } else if (temp < x) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
	 }
}
