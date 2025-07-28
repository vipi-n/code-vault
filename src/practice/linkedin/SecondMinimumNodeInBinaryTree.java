// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

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
class SecondMinimumNodeInBinaryTree {
    int firstMin;
    long secondMin = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        
        if (root == null) return -1;
        
        firstMin = root.val;
        traverse(root);
        return secondMin < Long.MAX_VALUE ? (int) secondMin : -1;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        if( root.val > firstMin && root.val < secondMin) {  
            secondMin = root.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
