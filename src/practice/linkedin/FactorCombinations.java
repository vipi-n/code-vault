// https://algo.monster/liteproblems/254

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        backtrack(n, 2, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int start, List<Integer> current) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                current.add(i);

                // Add a valid combination
                List<Integer> combination = new ArrayList<>(current);
                combination.add(n / i);
                result.add(combination);

                // Recurse
                backtrack(n / i, i, current);

                // Backtrack properly
                current.remove(current.size() - 1);
            }
        }
    }
}
