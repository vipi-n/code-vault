// https://leetcode.com/problems/balanced-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {

    boolean result = true;
    public boolean isBalanced(TreeNode root) {

        int depth = depth(root);
        return  result;
    }

    private int depth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        if(Math.abs(left - right) > 1) {
            result = false;
        }
        return 1 + Math.max(left, right);
    }
}
