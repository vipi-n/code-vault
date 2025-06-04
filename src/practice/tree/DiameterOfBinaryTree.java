// https://leetcode.com/problems/diameter-of-binary-tree/description/

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
class Solution {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
        
    }

    private int height(TreeNode root) {

        if(root == null) return 0;
        
        int leftH = height(root.left);
        int rightH = height(root.right);
        maxDiameter = Math.max(maxDiameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
