//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
           ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1);

        for (int num = 2; num <= N; num++) {
            int carry = 0;
            for (int i = 0; i < digits.size(); i++) {
                int product = digits.get(i) * num + carry;
                digits.set(i, product % 10);
                carry = product / 10;
            }

            while (carry > 0) {
                digits.add(carry % 10);
                carry /= 10;
            }
        }
        reverse(digits);

        return digits;
    }
    private static void reverse(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}