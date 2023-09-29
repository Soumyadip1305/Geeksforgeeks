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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
      HashSet<String > set = new HashSet<>();
        opt_app(0, S.toCharArray(), set);
        ArrayList<String >ans=new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    private static void opt_app(int ind, char[] arr, HashSet<String > ans) {
        if (ind == arr.length) {
            StringBuilder ds= new StringBuilder();
            for (char ele : arr) {
                ds.append(ele);
            }
            ans.add(ds.toString());
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind, arr);
            opt_app(ind + 1, arr, ans);
            swap(i, ind, arr);
        }
    }

    private static void swap(int i, int ind, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
}

