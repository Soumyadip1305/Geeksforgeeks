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
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
       Arrays.sort(candies);
        ArrayList<Integer>list=new ArrayList<>();
        list.add(minimumCost(candies,K));
        list.add(maximumCost(candies,K));
      return list;
    }

    static int minimumCost(int[] arr, int k) {
        int cost = arr[0];
        int n = arr.length - k;
        for (int i = 1; i < n; i++) {
            cost+=arr[i];
            n-=k;
        }return cost;
    }
    static int maximumCost(int[] arr, int k) {
        reverseArray(arr);
        int cost = arr[0];
        int n = arr.length - k;
        for (int i = 1; i < n; i++) {
            cost+=arr[i];
            n-=k;
        }return cost;
    }
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}