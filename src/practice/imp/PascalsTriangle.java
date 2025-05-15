// https://leetcode.com/problems/pascals-triangle/description/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        result.add(init);

        for(int i = 1; i < numRows; i++) {

            List<Integer> prev = result.get(i - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for(int j = 0; j < i - 1; j++) {
                temp.add(prev.get(j) + prev.get(j + 1));
            }
            temp.add(1);
            result.add(temp); 
        }
        return result;
    }
}
