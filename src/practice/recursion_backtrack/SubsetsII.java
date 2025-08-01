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

// better

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsets(nums, res, 0, temp);
        return res;
    }

    public void subsets(int[] nums, List<List<Integer>> res, int index, List<Integer> temp) {

        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) // here we checking if the i is not first element, if not then skip because its already taken in nums[i - 1]
                continue;
            temp.add(nums[i]);
            subsets(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
