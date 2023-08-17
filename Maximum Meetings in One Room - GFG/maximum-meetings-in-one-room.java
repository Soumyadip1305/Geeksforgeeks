//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
       static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean cmp(Pair a, Pair b) {
        return a.second < b.second;
    }

    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair p = new Pair(start[i], end[i]);
            pairs.add(p);
        }

        Map<Pair, Integer> pairToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!pairToIdx.containsKey(pairs.get(i))) {
                pairToIdx.put(pairs.get(i), i + 1);
            }
        }

        pairs.sort((a, b) -> cmp(a, b) ? -1 : 1);

        ArrayList<Integer> ans = new ArrayList<>();
        int endTime = pairs.get(0).second;
        int idx = pairToIdx.get(pairs.get(0));
        ans.add(idx);

        for (int i = 1; i < n; i++) {
            if (pairs.get(i).first > endTime) {
                idx = pairToIdx.get(pairs.get(i));
                ans.add(idx);
                endTime = pairs.get(i).second;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
