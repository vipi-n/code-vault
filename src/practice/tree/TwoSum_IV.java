package practice.tree;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST
 * such that their sum is equal to the given target.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TwoSum_IV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    public boolean dfs(TreeNode root, int k, HashSet<Integer> set){
        if(root == null) return false;

        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
