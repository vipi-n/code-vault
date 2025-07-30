// https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        getAllSubsetWithSumK(candidates, res, new ArrayList<>(), 0, 0, target);
        return res;
    }

    private void getAllSubsetWithSumK(int[] candidates, List<List<Integer>> res, List<Integer> list, int index, int sum,
            int target) {

        if (sum > target)
            return;

        if (index == candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candidates[index]);
        sum += candidates[index];
        getAllSubsetWithSumK(candidates, res, list, index, sum, target);

        sum -= candidates[index];
        list.remove(list.size() - 1);
        getAllSubsetWithSumK(candidates, res, list, index + 1, sum, target);

    }
}
