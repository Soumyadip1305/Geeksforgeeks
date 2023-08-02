//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
         Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            int x=arr[i];
            int low=i+1,high=size-1;
            while (low<=high){
                int mid=(low+high)/2;
                if (arr[mid]==x+n){
                    return true;
                } else if (arr[mid]<x+n) {
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }return false;
    }
}