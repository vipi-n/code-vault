// https://leetcode.com/problems/search-in-rotated-sorted-array/

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;


        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) { // left half sorted
                // if left half sorted this should be true
                if(nums[low] <= target && nums[mid] >= target) {
                   high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right half sorted
                // if right half sorted this should be true
                 if(nums[high] >= target && nums[mid] <= target) {
                   low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
