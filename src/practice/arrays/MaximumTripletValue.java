// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/

class MaximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        
        int n = nums.length;
        long sum = 0;

        for(int i = 2; i < n; i++) {
            int maxPrefix = nums[0];
            for(int j = 1; j < i; j++) {
                
                sum  = Math.max(sum, (long)(maxPrefix - nums[j]) * nums[i]);
                maxPrefix = Math.max(maxPrefix, nums[j]);
            }
        }
      if(sum < 0) {
        return 0;
      }
      return sum;
    }
}
