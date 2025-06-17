//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1

class PartitionsWithGivenDifference {
    public int countPartitions(int[] arr, int d) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        /*
         * To find number of partitions such that:
         *     sum(S1) - sum(S2) = d  -----------(1)
         *     sum(S1) + sum(S2) = sum ---------(2)
         * 
         * Adding (1) and (2):
         *     2 * sum(S1) = sum + d
         *     => sum(S1) = (sum + d) / 2
         * 
         * So we need to count the number of subsets with sum = (sum + d) / 2
         * 
         * BUT this is only valid if (sum + d) is even.
         * If (sum + d) is odd, then sum(S1) is not an integer,
         * and subset sums must be integers. So, no valid partition is possible.
         */
        if ((sum + d) % 2 != 0 || sum < d) {
            return 0;
        }

        int s1 = (sum + d) / 2;
      //it becomes a standard Subset Sum Count problem — how many subsets have sum = s1
        return findNoOfSubsetWithSum(arr, s1);
    }

    private int findNoOfSubsetWithSum(int[] arr, int s1) {
        int n = arr.length;
        int[][] dp = new int[n + 1][s1 + 1];
        
        // we can remove this since this is by default 0 in java
        for(int j = 0; j <= s1; j++) {
           dp[0][j] = 0; 
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // There is always 1 way to make sum 0: empty subset
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][s1];
    }
}
