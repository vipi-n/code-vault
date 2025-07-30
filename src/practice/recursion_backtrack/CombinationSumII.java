// https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        getAllSubsetWithSumK(candidates, res, new ArrayList<>(), 0, 0, target);
        return res;

    }

    private void getAllSubsetWithSumK(int[] candidates, List<List<Integer>> res, List<Integer> list, int index, int sum, int target) {
        if (sum > target) return; // Early pruning        

        if (index == candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candidates[index]);

        sum += candidates[index];
        getAllSubsetWithSumK(candidates, res, list, index + 1, sum, target);

        sum -= candidates[index];
        list.remove(list.size() - 1);

        int newIndex = index + 1;
        while(newIndex < candidates.length && candidates[index] == candidates[newIndex]) {
                newIndex++;
        }
        getAllSubsetWithSumK(candidates, res, list, newIndex, sum, target);

    }
}
