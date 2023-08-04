//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
       static long minTime(int[] arr, int n, int m) {
        long[] x = sum_max(arr);
        long low = x[1];
        long high = x[0];
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cntStudent = countStudent(arr, mid);
            if (cntStudent > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static long countStudent(int[] arr, long pages) {
        long students = 1;
        long pagesStudent = 0;
        for (long j : arr) {
            if (pagesStudent + j <= pages) {
                pagesStudent += j;
            } else {
                students++;
                pagesStudent = j;
            }
        }
        return students;
    }

    static long[] sum_max(int[] arr) {
        long sum = 0;
        long maxi = 0;
        for (int j : arr) {
            sum += j;
            maxi = Long.max(j, maxi);
        }
        return new long[]{sum, maxi};
    }
}