// https://algo.monster/liteproblems/339

class NestListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1); // Depth starts at 1
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += helper(ni.getList(), depth + 1); // Increase depth
            }
        }

        return sum;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer.
    // Return null if this NestedInteger holds a nested list.
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list.
    // Return empty list if this NestedInteger holds a single integer.
    public List<NestedInteger> getList();
}


