//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return constructBinary(preorder, inorder, 0,inorder.length - 1);
    }

    private TreeNode constructBinary(int[] preorder, int[] inorder, int startIn, int endIn) {

        if(startIn > endIn) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inIndex = startIn;
        for(int i = startIn; i <= endIn; i++) {
            if(inorder[i] == root.val) {
               inIndex = i;
               break;
            }
        }
        root.left = constructBinary(preorder, inorder, startIn, inIndex - 1);
        root.right = constructBinary(preorder, inorder, inIndex + 1, endIn);
        return root;
    }
}

