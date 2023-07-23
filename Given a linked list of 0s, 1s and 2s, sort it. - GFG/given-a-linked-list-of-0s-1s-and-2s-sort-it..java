//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
      if (head == null || head.next == null) {
            return head;
        }

        // Count the occurrences of 0s, 1s, and 2s
        int count_0 = 0, count_1 = 0, count_2 = 0;
        Node current = head;
        while (current != null) {
            if (current.data == 0) {
                count_0++;
            } else if (current.data == 1) {
                count_1++;
            } else {
                count_2++;
            }
            current = current.next;
        }

        // Modify node values based on counts
        current = head;
        while (current != null) {
            if (count_0 > 0) {
                current.data = 0;
                count_0--;
            } else if (count_1 > 0) {
                current.data = 1;
                count_1--;
            } else {
                current.data = 2;
                count_2--;
            }
            current = current.next;
        }

        return head;
    }
}