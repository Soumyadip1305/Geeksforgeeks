//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        return findPages(arr,N,K);
    }
    public static int findPages(int[] arr, int n, int m) {
        if (m > n) {
            return -1;
        }
        int low = max(arr);
        int high = sum(arr);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cntStudent = countStudent(arr, mid);
            if (cntStudent > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int countStudent(int[] arr, int pages) {
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= pages) {
                pagesStudent += arr[i];
            } else {
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
    static  int sum(int[] arr){
        int sum=0;
        for (int j : arr) {
            sum += j;
        }return sum;
    }
    static  int max(int[]arr){
        int maxi =0;
        for (int j : arr) {
            maxi =Integer.max(j,maxi);
        }return maxi;
    }
}