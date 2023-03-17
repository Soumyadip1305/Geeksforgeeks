//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
 ArrayList<Integer> list = new ArrayList<>();
        func(0,0,arr,N,list);
        Collections.sort(list);
        return list;   
        }
     void func(int ind, int sum, ArrayList<Integer> list, int N, ArrayList<Integer> subsetSum) {
        if (ind == N) {
            subsetSum.add(sum);
            return;
        }
        // pick the element
        func(ind + 1, sum + list.get(ind), list, N, subsetSum);

        // Not pick
        func(ind + 1, sum, list, N, subsetSum);
    }
}