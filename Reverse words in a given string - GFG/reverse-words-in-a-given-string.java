//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
          ArrayList<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '.') s += S.charAt(i);
            else {
                list.add(s);
                s = "";
            }
        }

        list.add(s);
        StringBuilder ans= new StringBuilder();
        for (int i = list.size()-1; i >=0 ; i--) {
            ans.append(list.get(i));
            ans.append('.');
        }
        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
    }
}