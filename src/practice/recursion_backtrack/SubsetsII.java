// https://leetcode.com/problems/subsets-ii/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, list, result);
        return result;

    }

    public void backTrack(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if (index == nums.length) {
            if (result.contains(list))
                return;
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
