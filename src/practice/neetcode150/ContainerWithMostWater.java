// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        int minHeight = 0;

        while(left < right) {

           minHeight = Math.min(height[left], height[right]); // get the min height, and the max water would be between them, next left++/right-- accordingly 
           maxWater = Math.max(maxWater, (right - left) * minHeight); 

           if(minHeight == height[left]) {
            left++;
           } else {
            right--;
           }
        }
        return maxWater;
    }
}
