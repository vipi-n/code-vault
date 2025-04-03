// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/


class MaximumTripletValue {
    public long maximumTripletValue_WithSpace(int[] nums) {

        
        int len = nums.length;
        int[] arr = new int[len];
        int maxRight = nums[len - 1];

        for(int i = len - 2; i > 0; i--) {
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, nums[i]);
           
        }
        int x = nums[0];
        long sum = 0;
        for(int i = 1; i < len; i ++) {
             sum = Math.max(sum, (long)(x - nums[i])*arr[i]);
             x = Math.max(x, nums[i]); 
        }
        return sum;
    }

    public long maximumTripletValue(int[] nums) {
        
        long dMax = 0;
        long iMax = 0;
        long sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, dMax * nums[i]); // 0 0 6 22 77
            dMax = Math.max(dMax, iMax - nums[i]); // 0 6 11 11 11
            iMax = Math.max(iMax, nums[i]);// 12 12 12 12 12
        }
        return sum;
    }
    
}
