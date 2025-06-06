// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// efficient


// efficient
class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;

        while(curr != null) {
            if(curr.val < p.val && curr.val < q.val) {
              curr = curr.right;
            } else if(curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }

    //naive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Lists to store paths from root to p and q
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        // If either p or q is not present in the tree, return null
        if (!findPath(root, p, path1) || !findPath(root, q, path2)) {
            return null;
        }

        // Compare both paths to find the last common node
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            // As soon as the paths diverge, return the previous node
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }

        // If one path is a complete subset of the other, return the last node in the shorter path
        return path1.get(Math.min(path1.size(), path2.size()) - 1);
    }

    // Helper method to find the path from root to the given node
    public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) return false;

        // Add current node to the path
        path.add(root);

        // If the current node is the target, return true
        if (root.val == node.val) return true;

        // Recursively search in left or right subtree
        if (findPath(root.left, node, path) || findPath(root.right, node, path)) {
            return true;
        }

        // If not found in either subtree, remove the current node from path and backtrack
        path.remove(path.size() - 1);
        return false;
    }
}
