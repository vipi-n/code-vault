// https://algo.monster/liteproblems/366
// https://leetcode.com/problems/find-leaves-of-binary-tree/description/

package org.example;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (result.size() <= currHeight) {
            result.add(new ArrayList<>());
        }
        result.get(currHeight).add(root.val);
        return currHeight;
    }
}

