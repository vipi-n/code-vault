
// top down
class HouseRobber {
    public int rob(int[] nums) {

     int n = nums.length;
     int[] dp = new int[n + 1];
     Arrays.fill(dp, -1);
     return max(nums, n, dp);
    }

    private int max(int[] nums, int n, int[] dp) {
    if(n <= 0) {
        return 0;
     }
     if(dp[n] != -1) {
        return dp[n];
     }
     int take = nums[n - 1] + max(nums, n - 2, dp);
     int notTake = max(nums, n - 1, dp);
     dp[n] = Math.max(take, notTake);

     return dp[n];

    }
  public int rob_Optimized(int[] nums) {

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++) {
            
            int rob = nums[i];
            if(i > 1) rob += prev2; // you can just remove if(i > 1)

            int notRob = 0 + prev;
            int maxRob = Math.max(rob, notRob);

            prev2 = prev;
            prev = maxRob;
        }
        return prev;
    }
}
