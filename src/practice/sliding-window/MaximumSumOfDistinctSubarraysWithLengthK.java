// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

// Related to MaxSumSubarrayOfSizeK

class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int i = 0, j = 0;
        long currSum = 0, maxSum = 0;

        while (j < n) {
            // Remove duplicates by shrinking window from left
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                currSum -= nums[i];
                i++;
            }

            // Add current element
            set.add(nums[j]);
            currSum += nums[j];

            // Check if window size is k
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, currSum);

                // Slide window by removing leftmost
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return maxSum;
    }
}
