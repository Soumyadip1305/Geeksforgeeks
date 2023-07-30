//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

            

class Complete{
    
  
    int KthMissingElement(int arr[], int n, int k)
    {int low=0,high= arr.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1);
            if(arr[mid]-(arr[0]+mid)<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        } if(arr[0]+high+k>arr[arr.length-1]){
            return -1;
        }return arr[0]+high+k;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		   
		    int res = obj.KthMissingElement(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends