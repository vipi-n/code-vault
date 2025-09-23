// https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {

       if(n <= 1) return 1;

       return  climbStairs(n - 1) + climbStairs(n - 2);
    }


  // Memeoization    
  public int climbStairsMemo(int n) {
       int[] dp = new int[n + 1];
       Arrays.fill(dp, -1);
       return climb(n, dp);
       
    }
    private int climb(int n, int[] dp) {

        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
       return  dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
    }

  // tabulation
  public int climbStairs(int n) {
       
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
    
        for(int i = 2; i <= n; i++) {
          dp[i] = dp[i - 1] + dp[i - 2];
        }
       return dp[n];
       
    }

}
