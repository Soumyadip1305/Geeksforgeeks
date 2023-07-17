//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String s)
    {
        int n = s.length();
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                queue.add(ch);
            }

            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove();
            }

            if (queue.isEmpty()) {
                ans.append("#");
            } else {
                ans.append(queue.peek());
            }
        }

        return ans.toString();
    }
}