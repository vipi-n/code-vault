// https://leetcode.com/problems/house-robber/description/
// https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261

class Solution {
    // rec
    public int rob(int[] nums) {

        return robber(nums, nums.length - 1);
    }
    
    private int robber(int[] nums, int n) {

        if (n == 0)
            return nums[0];
        if (n < 0)
            return 0;

        int pick = nums[n] + robber(nums, n - 2);
        int notPick = robber(nums, n - 1);
        return Math.max(pick, notPick);
    }

  // memoization
  public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, - 1);
        return robber(nums, nums.length - 1, dp);
    }

    private int robber(int[] nums, int n, int[] dp) {

        if (n == 0)
            return nums[0];
        if (n < 0)
            return 0;

        if(dp[n] != -1) return dp[n];   

        int pick = nums[n] + robber(nums, n - 2, dp);
        int notPick = robber(nums, n - 1, dp);
        return dp[n] = Math.max(pick, notPick);
    }

  //tabulation
  public int rob(int[] nums) {

        return robber(nums);
    }

    private int robber(int[] nums) {

        int[] dp = new int[nums.length];
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0]; 

        dp[0] =  nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
        int pick = nums[i] + dp[i - 2];
        int notPick = dp[i - 1];
        dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

  // space optimzation

  public int rob(int[] nums) {

        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            
            int pick = nums[i] + prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
