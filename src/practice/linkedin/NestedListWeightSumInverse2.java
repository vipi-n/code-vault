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

// can understand:

package org.example;

import java.util.List;

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = maxDepth(nestedList, 1);
        return getWeightedSum(nestedList, 1, maxDepth);
    }
    // First pass: get max depth
    // Traverse each element; if it's a list, go one level deeper and recurse.
    public int maxDepth(List<NestedInteger> nestedList, int depth) {
        int max = depth;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                max = Math.max(max, maxDepth(ni.getList(), depth + 1));
            }
        }
        return max;
    }
    // Second pass: compute weighted sum
    public int getWeightedSum(List<NestedInteger> nestedList, int depth, int maxDepth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * (maxDepth - depth + 1);
            } else {
                sum += getWeightedSum(ni.getList(), depth + 1, maxDepth);
            }
        }
        return sum;
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

