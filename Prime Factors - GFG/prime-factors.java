//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
  private static ArrayList<Integer> solve(int n) {
        boolean[] prime = new boolean[n + 1];
        int[]highestPrime = new int[n + 1];
        Arrays.fill(highestPrime, 0);
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= n; i++) {  // You can replace n to Math.sqrt(n)
            if (prime[i]) {
                 highestPrime[i] = i;
                for (int j = 2 * i; j <= n; j += i) {// you can replace 2*i to i*i
                    prime[j] = false;
                    highestPrime[j] = i;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 1) {
            int prime_fact = highestPrime[n];
            while (n % prime_fact == 0) {
                n /= prime_fact;
                if (!list.contains(prime_fact)) {
                    list.add(prime_fact);
                }
            }
        }
        return list;
    }

    public static int[] AllPrimeFactors(int N) {
        ArrayList<Integer>list= solve(N);
        int []ans=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        } Arrays.sort(ans);
        return ans;
    }
    }