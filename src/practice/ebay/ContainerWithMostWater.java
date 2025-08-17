// https://leetcode.com/problems/container-with-most-water/


class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxWater = 0;

        while (i < j) {

            int currMaxWater = Math.min(height[i], height[j]) * (j - i);
            maxWater = Math.max(maxWater, currMaxWater);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return maxWater;
    }
}
