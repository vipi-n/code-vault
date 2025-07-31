// https://leetcode.com/problems/sort-an-array/
// Use Merge sort for this problem

// TC - nlogn, O(N ^ 2) if we end up choosing the largest or smallest element as the pivot always
class Solution {
    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
        
    }

    private void quickSort(int[] nums, int low, int high) {
        
        if(low >= high) return;

        int partitionInx = func(nums, low, high);
        // partitionInx means this index element is present at the correct place, not we need to call qs in both halves
        quickSort(nums, low, partitionInx - 1);
        quickSort(nums, partitionInx + 1, high);
    }

    private int func(int[] nums, int low, int high) {

        int i = low;
        int j = high;
        int pivot = nums[low];

        while(i < j) {
            // go on until elements are <= to pivot since we want the higher element in the right side of pivot and lower in the left side
            while(nums[i] <= pivot && i < high) {
                i++;
            }
             while(nums[j] > pivot && j > low) {
                j--;
            }
            if(i < j) {
                // in the above while loop it will go on until they find any violance and then we swap
                swap(nums, i, j);
            }
        }
        // swap with the last j and pivot, since the place of pivot is at j and return the partitionIndex
        swap(nums, j, low);
        return j;
        
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
