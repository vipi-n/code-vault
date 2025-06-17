// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class MinimumSumPartition {

    boolean[][] dp;

    public int minDifference(int arr[]) {
        int range = 0;
        
        // Calculate total sum(range) of the array
        for (int i : arr) {
            range += i;
        }

        // Populate subset sum dp table
        subsetSum(arr, range);

        List<Integer> ls = new ArrayList<>();

        // Collect all subset sums possible from 0 to range/2 (only last row)
        for (int j = 0; j <= range / 2; j++) {
            if (dp[arr.length][j]) {
                ls.add(j);
            }
        }

        // Calculate minimum absolute difference
        // suppose two subset is s1 and s2, and the max the range will be(0, range)
        // so if s1 is s1, then s2 must be range - s1
        // the min of abs(range - s1 - (s1)) -> abs(range - 2s1) - find the min of this and that will be the min sum difference
        // so we are first checking the subsetsum with range, and taking only last row
        int minSum = Integer.MAX_VALUE;
        for (int i : ls) {
            minSum = Math.min(minSum, Math.abs(range - 2 * i));
        }

        return minSum;
    }

    private void subsetSum(int arr[], int range) {
        int n = arr.length;
        dp = new boolean[n + 1][range + 1];

        // Initialize first row (sum > 0 not possible with 0 elements)
        for (int j = 0; j <= range; j++) {
            dp[0][j] = false;
        }

        // Initialize first column (sum 0 is possible with any number of elements - by choosing empty set)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the subset sum dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }
}
