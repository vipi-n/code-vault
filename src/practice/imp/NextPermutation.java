// https://leetcode.com/problems/next-permutation/

class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        int pivot = -1;

        for(int i = len - 2; i >= 0; i--) {

            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if(pivot != -1) {
            for(int i = len - 1; i > pivot; i--) {
                if(nums[i] > nums[pivot]) {
                  swap(nums, pivot, i);
                  break;    
                }
            }
                 
        }
        reverse(nums, pivot + 1, len - 1);

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        
        while(start < end) {

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
        }
        
    }
}
