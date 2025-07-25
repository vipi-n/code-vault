// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        
        for(int i : nums) {
            sum += i;
        }
        if(sum % k != 0) return false;
        if(nums.length < k) return false;

        int targetSum = sum / k;
        boolean[] visited = new boolean[nums.length];

       return canPartition(nums, k, 0, 0, targetSum, visited);
    }

    public boolean canPartition(int[] nums, int k, int start, int currSum, int targetSum, boolean[] visited) {

        if(k == 0) return true;
        if(currSum > targetSum) return false;
        if(currSum == targetSum) {
            return canPartition(nums, k - 1, 0,0, targetSum, visited);
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(canPartition(nums, k, i + 1, currSum + nums[i], targetSum, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
