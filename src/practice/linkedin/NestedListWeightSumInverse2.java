// https://www.geeksforgeeks.org/dsa/find-nested-list-weight-sum-ii/

// This is the interface provided by LeetCode
// You should NOT implement it, only use it as given

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class NestedListWeightSumInverse2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int totalSum = 0;
        int prevLevelSum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();

                if (current.isInteger()) {
                    levelSum += current.getInteger();
                } else {
                    queue.addAll(current.getList());
                }
            }

            prevLevelSum += levelSum;
            totalSum += prevLevelSum;
        }

        return totalSum;
    }
}

// reccuresive - https://www.youtube.com/watch?v=-t_vRG5S-Os

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    public int helper(List<NestedInteger> list, int sum) {
        int total = sum;
        List<NestedInteger> tmp = new ArrayList<>();

        for (NestedInteger e : list) {
            if (e.isInteger()) {
                total += e.getInteger();
            } else {
                tmp.addAll(e.getList());
            }
        }

        if (!tmp.isEmpty()) {
            return total + helper(tmp, total);
        }

        return total;
    }
}

