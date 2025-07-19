// https://www.naukri.com/code360/problems/upside-down-binary-tree_1281853?leftPanelTabValue=PROBLEM
// https://algo.monster/liteproblems/156
// https://chatgpt.com/s/t_687ba87221a4819194ffe336be45fefb

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
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

class UpsideDownBinaryTree {
  
    public TreeNode upsideDownBinaryTree_(TreeNode root) {


        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree_(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}

