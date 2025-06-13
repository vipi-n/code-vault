//https://leetcode.com/problems/partition-equal-subset-sum/

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

       int sum = 0;
       int n = nums.length;
       for(int i = 0; i < n; i++) {
          sum += nums[i];
       }
       if(sum % 2 != 0) {
        return false;
       } else {
          return subSetSum(nums, sum / 2);
       }
    }

    private boolean subSetSum(int[] nums, int sum) {

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for(int j = 0; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for(int i = 1; i < n + 1; i++) {

            for(int j = 1; j < sum + 1; j++) {
               
               if(j >= nums[i - 1]) {
                dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
               } else {
                dp[i][j] = dp[i - 1][j];
               }
            } 
        }
        return dp[n][sum];
    }
}
