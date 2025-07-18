// https://leetcode.com/problems/count-number-of-nice-subarrays/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        return numSubarraysWithSumAtMostK(nums, k) - numSubarraysWithSumAtMostK(nums, k - 1);
    }

    public int numSubarraysWithSumAtMostK(int[] nums, int goal) {

        int n = nums.length;
        int sum = 0;
        int count = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            sum += nums[j];
            while (i <= j && sum > goal) {
                sum = sum - nums[i];
                i++;
            }
            count += (j - i) + 1;
        }
        return count;
    }
}
