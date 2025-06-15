// https://leetcode.com/problems/min-cost-climbing-stairs/description/

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2; i < n + 1; i++) {
            // To reach step i, you can come either from
            // i - 1 and pay cost[i - 1] OR i - 2 and pay cost[i - 2]
           dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[n];
    }

  public int minCostClimbingStairs_Space(int[] cost) {

        int n = cost.length;
        int prev1 = 0;
        int prev2 = 0;
        int res = 0;
        
        for(int i = 2; i <= n; i++) {

           res = Math.min(cost[i - 1] + prev1, cost[i - 2] + prev2);
           prev2 = prev1;
           prev1 = res;
        }
        return prev1;
    }
}
