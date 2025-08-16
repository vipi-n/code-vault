// https://leetcode.com/problems/binary-tree-cameras/
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
    Set<TreeNode> visited;
    int cam;
    public int minCameraCover(TreeNode root) {

        visited = new HashSet<>();
        cam = 0;
        visited.add(null); // so null children are considered "covered"
        dfs(root, null);
        return cam;
        
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if(node != null){

            dfs(node.left, node);
            dfs(node.right, node);

            // node is root and not covered
            // immediate child is uncovered
            if((parent == null && !visited.contains(node)) || (!visited.contains(node.left) || !visited.contains(node.right))) {
                cam++;
                visited.add(node);
                visited.add(parent);
                visited.add(node.right);
                visited.add(node.left);
            }
        }
    }
}

//

class Solution {
    int cam;

    public int minCameraCover(TreeNode root) {
        cam = 0;
        if (dfs(root) == 0) { // root uncovered → place a camera
            cam++;
        }
        return cam;
    }

   
    // 0 = not covered
    // 1 = covered (no camera here)
    // 2 = has camera
    private int dfs(TreeNode node) {
        if (node == null) return 1; // null is considered covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) { // any child not covered → put camera here
            cam++;
            return 2;
        }
        if (left == 2 || right == 2) { // child has camera → this is covered
            return 1;
        }
        return 0; // both children covered, none has camera → this is not covered
    }
}
