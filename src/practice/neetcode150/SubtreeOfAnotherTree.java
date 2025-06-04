// https://leetcode.com/problems/subtree-of-another-tree/

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Check if the current tree is the same
        if (isSameTree(root, subRoot)) return true;

        // Otherwise check recursively on left and right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
