// https://leetcode.com/problems/maximum-product-subarray/description/

class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int maxMul = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < n; i++) {
           int num = nums[i];
           
           if(num < 0) {
            int temp = maxSoFar;
            maxSoFar = minSoFar;
            minSoFar = temp;
           }
            
            maxSoFar = Math.max(num, maxSoFar * num);
            minSoFar = Math.min(num, minSoFar * num);
            maxMul = Math.max(maxMul, maxSoFar);

        }
        return maxMul;
    }
}
