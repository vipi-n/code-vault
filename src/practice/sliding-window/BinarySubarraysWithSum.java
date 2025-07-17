// https://leetcode.com/problems/binary-subarrays-with-sum/description/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

  // optimized

  public int numSubarraysWithSum(int[] nums, int goal) {

        return numSubarraysWithSumAtMostGoal(nums, goal) - numSubarraysWithSumAtMostGoal(nums, goal - 1);
    }
    public int numSubarraysWithSumAtMostGoal(int[] nums, int goal) {

        int n = nums.length;
        int sum = 0;
        int count = 0;
        int i = 0;
        
        for (int j = 0; j < n; j++) {

            sum += nums[j];
            while (i <= j && sum > goal) {
                sum = sum - nums[i];
                i++;
            }
            count += (j - i) + 1;
        }
        return count;
    }
  
}

