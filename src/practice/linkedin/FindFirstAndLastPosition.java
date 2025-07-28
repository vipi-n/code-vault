// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        return new int[]{findFirst(nums, target), findSecond(nums, target)};
       
    }

    public int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

        public int findSecond(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int second = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                second = mid;
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return second;
    }
}
