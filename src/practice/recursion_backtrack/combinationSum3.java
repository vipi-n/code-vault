// https://leetcode.com/problems/combination-sum-iii/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        getAllSubsetWithSumK(1, k, res, new ArrayList<>(), 1, 0, n);
        return res;

    }

    private void getAllSubsetWithSumK(int num, int k, List<List<Integer>> res, List<Integer> list, int index, int sum,
            int target) {

        if (sum > target || list.size() > k || index > 10)
            return;

        if (list.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(num);
        sum += num;
        getAllSubsetWithSumK(num + 1, k, res, list, index + 1, sum, target);
        sum -= num;
        list.remove(list.size() - 1);
        getAllSubsetWithSumK(num + 1, k, res, list, index + 1, sum, target);

    }
}

// More readable with less parameter

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        getAllSubsetWithSumK(1, k, res, new ArrayList<>(), n);
        return res;
    }

    private void getAllSubsetWithSumK(int num, int k, List<List<Integer>> res, List<Integer> list, int target) {
        
        if(num > 10) return;
        
        if (list.size() == k && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(num);
        getAllSubsetWithSumK(num + 1, k, res, list, target - num);

        list.remove(list.size() - 1);
        getAllSubsetWithSumK(num + 1, k, res, list, target);
    }
}


// for loop

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        getAllSubsetWithSumK(1, k, res, new ArrayList<>(), n);
        return res;
    }

    private void getAllSubsetWithSumK(int num, int k, List<List<Integer>> res, List<Integer> list, int target) {
        
        if (list.size() == k && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = num; i < 10; i++) {

        if(i > target) return;

        list.add(i);
        getAllSubsetWithSumK(i + 1, k, res, list, target - i);

        list.remove(list.size() - 1);
        }
    }
}
