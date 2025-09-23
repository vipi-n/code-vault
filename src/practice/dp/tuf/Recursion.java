
public class Main {

// res
// TC O(2^n) | SC = O(n)
private static int rec(int n) {
    if(n <= 1) return n; 
    return rec(n - 1) + rec(n - 2);
}
  
// memoization
// TC O(n) | SC = O(n)
  
    private static int rec(int n, int[] dp) {

        if(n <= 1) return n;
        if (dp[n] != -1) return dp[n];

        return dp[n] = rec(n - 1, dp) + rec(n - 2, dp);
    }
}

// tabulation
// TC O(n) | SC = O(n)

    private static int rec(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
             dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

// TC O(n) | SC = O(1)
private static int rec(int n) {

        int prev2 = 0;
        int prev = 1;
        
        for (int i = 2; i <= n; i++) {
            int res = prev + prev2;
             prev2 = prev;
             prev = res;
        }
        return prev;
    }
