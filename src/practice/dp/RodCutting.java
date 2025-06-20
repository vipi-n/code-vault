// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

// same as unbounded knapsack

class RodCutting {
    public int cutRod(int[] prices) {
        int rodTotalLength = prices.length;

        // Generate rod lengths [1, 2, ..., rodTotalLength]
        int[] lengths = new int[rodTotalLength];
        for (int i = 0; i < rodTotalLength; i++) {
            lengths[i] = i + 1;
        }

        int[][] dp = new int[rodTotalLength + 1][rodTotalLength + 1];

        for (int i = 1; i <= rodTotalLength; i++) {
            for (int j = 1; j <= rodTotalLength; j++) {
                if (lengths[i - 1] <= j) {
                    dp[i][j] = Math.max(
                        prices[i - 1] + dp[i][j - lengths[i - 1]],
                        dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[rodTotalLength][rodTotalLength];
    }
}
