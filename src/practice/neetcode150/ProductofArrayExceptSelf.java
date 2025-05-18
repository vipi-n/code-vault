// https://leetcode.com/problems/product-of-array-except-self/description/

//Extra space:

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
       
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
            // suf[3] = 1
            // suf[2] = suf[3] * nums[3] 4   
            // suf[1] = suf[2] * nums[2] 12
            // suf[0] = suf[1] * nums[1] 24
        }
        for(int i = 0; i < n; i++) {
            
            arr[i] = pre[i] * suf[i];
        }
        return arr;
    }

    //optimized

    public int[] productExceptSelfOptimized(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int curr = 1;
        Arrays.fill(ans, 1);
        
        // [1,2,3,4]
        for(int i = 0; i < n; i++) {
           ans[i] *= curr; // 1  1 2 6
           curr *= nums[i]; // 1 2 6 24
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) { 
           ans[i] *= curr; // 6 8 12 24
           curr *= nums[i]; // 4 12 24
             
        }
        return ans;
    }
}


