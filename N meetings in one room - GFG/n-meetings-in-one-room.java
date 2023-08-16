//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
           ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(start[i], end[i]));
        }
        list.sort(new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2) {
                return pair1.second().compareTo(pair2.second());
            }
        });
        int ct = 1;
        int endTime = list.get(0).second;

        for (int j = 1; j <n ; j++) {
            int startTime = list.get(j).first;
            if (endTime < startTime) {
                ct++;
                endTime=list.get(j).second;
            }
        }
        return ct;
    }

    public static class Pair<K, V> {
        private K first;
        private V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {

        }

        public K first() {
            return first;
        }

        public V second() {
            return second;
        }
    }
}