// https://leetcode.com/problems/binary-tree-right-side-view/

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
    List<Integer> res = new ArrayList<>();
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        int level = 1;
        printRight(root, level);
        return res;
    }
    private void printRight(TreeNode root, int level) {
        
        if(root == null) {
            return;
        }
        if(maxLevel < level) {
            res.add(root.val);
            maxLevel = level;
        }
        printRight(root.right, level + 1);
        printRight(root.left, level + 1);
    }
}
