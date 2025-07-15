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

// optimized - find the maxLen of subarray with atmost k 0s

    public int longestOnes_Optimized(int[] nums, int k) {

        int maxLen = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        while (right < n) {

            if(nums[right] == 0) {
               zeroCount++; 
            }
            if(zeroCount <= k) {
              maxLen = Math.max(maxLen, right - left + 1);
            } else {
                while(zeroCount > k) {
                  if(nums[left] == 0) {
                    zeroCount--;
                  }
                  left++;
                }
            }
            right++;
        }
        return maxLen;
    }

        public int longestOnes_more(int[] nums, int k) {

        int maxLen = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        while (right < n) {

            if(nums[right] == 0) {
               zeroCount++; 
            }
            if(zeroCount <= k) {
              maxLen = Math.max(maxLen, right - left + 1);
            } else {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                  left++;
            }
            right++;
        }
        return maxLen;
    }
}
