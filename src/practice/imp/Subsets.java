// https://leetcode.com/problems/subsets/

class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
         allSubs(nums, 0, new ArrayList<>());
         return result;
    }

    public void allSubs(int[] nums, int i, List<Integer> list) {
        
        if(i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        allSubs(nums, i + 1, list);
        list.add(nums[i]);
        allSubs(nums, i + 1, list);
        list.remove(list.size() - 1);
    }
}
