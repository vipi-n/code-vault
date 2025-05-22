// https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
      List<List<Integer>> res = new ArrayList<>();
      Set<List<Integer>> set = new HashSet<>();
      Arrays.sort(nums);
      int target = 0;

      for(int i = 0; i < nums.length; i++) {

        int newTarget = target - nums[i];
        int left = i + 1;
        int right = nums.length - 1;

        while(left < right) {

            if(nums[left] + nums[right] == newTarget) {
                set.add(Arrays.asList(nums[left], nums[right], nums[i]));
                left++;
                right--;
            } else if(nums[left] + nums[right] > newTarget) {
                right--;
            } else{
                left++;
            }
        }
      }
      res.addAll(set);
      return res;  
    }

    // no space
    public List<List<Integer>> threeSumWithoutSpace(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
