//https://leetcode.com/problems/subarray-sum-equals-k/

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

       HashMap<Integer, Integer> map = new HashMap<>();
       int sum = 0;
       int count = 0;

       for(int i = 0; i < nums.length; i++) {

          sum += nums[i];
          if(sum == k) count++;

          if(map.containsKey(sum - k)) {
            count += map.get(sum - k);
          }
          map.put(sum, map.getOrDefault(sum , 0) + 1);
       } 
       return count;
    }
}
