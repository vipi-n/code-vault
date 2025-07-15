//https://leetcode.com/problems/max-consecutive-ones-iii/

// brute
class Solution {
    public int longestOnes(int[] nums, int k) {

        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int zero = 0;
            for (int j = i; j < n; j++) {

                if (nums[j] == 0) {
                    zero++;
                }
                if (zero <= k) {
                    int max = j - i + 1;
                    maxLen = Math.max(maxLen, max);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
