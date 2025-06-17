// https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

class UnboundedKnapsack {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int n = val.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= capacity; j++) {
                
                if(j >= wt[i - 1]) {
                    dp[i][j] =  Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
