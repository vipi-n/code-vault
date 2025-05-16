// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/

// brute force:

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
     
     int max = nums[0];
     for(int i : nums) {
         max = Math.max(max, i);
     }

     for(int i = 1; i <= max; i++) {
        if(canDevide(i, nums, maxOperations)) {
            return i;
        }
     } 
     return -1; 
    }

    private boolean canDevide(int num, int[] nums, int maxOperations) {

        int ops = 0;
        
        for(int i = 0; i < nums.length; i++) {
            ops += (int)Math.ceil((double)nums[i] / num) - 1;
            if(ops > maxOperations) {
                return false;
            }
        }
       return true;
    }
}






class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
     
     int max = nums[0];
     for(int i : nums) {
         max = Math.max(max, i);
     }

     int left = 1;
     int right = max;

     while(left < right) {

        int mid = (right + left) / 2;
        if(canDevide(mid, nums, maxOperations)) {
            right = mid;
        } else {
            left = mid + 1;
        }
     }
     return left; 
    }

    private boolean canDevide(int num, int[] nums, int maxOperations) {

        int ops = 0;
        
        for(int i = 0; i < nums.length; i++) {
            ops += (int)Math.ceil((double)nums[i] / num) - 1;
            if(ops > maxOperations) {
                return false;
            }
        }
       return true;
    }
}
