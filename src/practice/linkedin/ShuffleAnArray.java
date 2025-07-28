// https://leetcode.com/problems/shuffle-an-array/description/

class Solution {

    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {

        int[] copy = nums.clone();

        for (int i = nums.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = copy[j];
            copy[j] = copy[i];
            copy[i] = temp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
