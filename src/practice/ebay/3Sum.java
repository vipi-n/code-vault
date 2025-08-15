// https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while(j < k) {

                int total = nums[i] + nums[j] + nums[k];

                if(total > 0) {
                    k--;
                } else if(total < 0) {
                    j++;
                } else {
                   res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                   j++;
                   k--;
                   while(k > j && nums[j] == nums[j - 1]) j++; // skipping dup j
                   while(k > j && nums[k] == nums[k + 1]) k--; // skipping dup k
                  

                }
            }
        }
        return res;
    }
}
