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
        if(root == null) return 0;
        cam = 0;
        dfs(root);
        return cam;
        
    }
    // 0 : not covered
    // 1 : covered
    // 2 has camera
    public int dfs(TreeNode node) {
        if(node == null){
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(left == 0 || right == 0) {
           cam++;
           return 2;
        } else if(left == 2 || right == 2) {
            return 1;
        } else {
            return 0;
        } 
        
    }
}
