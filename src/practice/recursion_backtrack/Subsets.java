// same as subsequence
// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, list, result);
        return result;
    }

    public void backTrack(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {

        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        //take
        backTrack(nums, index + 1, list, result);
        list.remove(list.size() - 1);
        //not take
        backTrack(nums, index + 1, list, result);
    }
}

// OR

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        getAllSubset(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void getAllSubset(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {

        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            getAllSubset(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
