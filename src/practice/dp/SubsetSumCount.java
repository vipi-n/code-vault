//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class SubsetSumCount {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

       // No way to make positive sum using 0 elements
       for (int j = 0; j <= target; j++) {
            dp[0][j] = 0;
        }
        // Only sum 0 is possible with any number of elements: 1 way (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}

