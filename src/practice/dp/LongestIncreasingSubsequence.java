// https://leetcode.com/problems/longest-increasing-subsequence/description/
// Rec
class Solution {
    int res = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        
        return lis(nums, 0, -1, nums.length);
    }

    private int lis(int[] nums, int index, int prev_ind, int n) {

        if(index == n) return 0;

        int notTake = lis(nums, index + 1, prev_ind, n);
        int take = 0;
        if(prev_ind == -1 || nums[index] > nums[prev_ind]) {
            take =  1 +  lis(nums, index + 1, index, n);
        }
        return Math.max(notTake, take);
    }
}

// memo
class Solution {
    int res = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return lis(nums, 0, -1, n, dp);
    }

    private int lis(int[] nums, int index, int prev_ind, int n, int[][] dp) {

        if(index == n) return 0;
        
        if(dp[index][prev_ind + 1] != -1) return dp[index][prev_ind + 1];
        int len = lis(nums, index + 1, prev_ind, n, dp);
        if(prev_ind == -1 || nums[index] > nums[prev_ind]) {
            len =  Math.max(len, 1 +  lis(nums, index + 1, index, n, dp));
        }
        return dp[index][prev_ind + 1] = len;
    }
}
