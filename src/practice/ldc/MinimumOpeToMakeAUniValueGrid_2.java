// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

class inimumOpeToMakeAUniValueGrid_2 {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int minOp = 0;

        for(int i = 0; i < nums.length; i++) {
            int count = Math.abs(nums[i] - median);
            minOp += count;
        }
        return minOp;
    }
}
