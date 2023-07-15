//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
           int n=0;
        if (sizeOfStack%2==0){
            n=sizeOfStack/2;
        }else {
            n=(sizeOfStack)/2+1;
        }
        Stack<Integer> list=new Stack<>();
        while (sizeOfStack!=n){
            list.add(s.pop());
            sizeOfStack-=1;
        }
        s.pop();
        int p=list.size();
       while (p>0){
           s.push(list.pop());
           p-=1;
       }
    }
}

