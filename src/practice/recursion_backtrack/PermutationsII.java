// https://leetcode.com/problems/permutations-ii/
// TC = O(n! × n)
/*
SC = O(n × n!)  for output
   + O(n)       for recursion and temp list
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, res, 0);
        return res;
    }

    public void permutation(int[] nums, List<List<Integer>> res, int index) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            swap(nums, i, index);
            permutation(nums, res, index + 1);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
