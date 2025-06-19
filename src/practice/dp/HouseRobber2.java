// https://leetcode.com/problems/house-robber-ii/description/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: rob houses 0 to n - 2
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: rob houses 1 to n - 1
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // house robber 1
    private int robLinear(int[] nums, int start, int end) {
        int prev = nums[start];
        int prev2 = 0;

        for (int i = start + 1; i <= end; i++) {
            int rob = nums[i] + prev2;
            int notRob = prev;
            int curr = Math.max(rob, notRob);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
