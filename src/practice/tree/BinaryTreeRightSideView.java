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
        printRight(root.right, level + 1); // for left view swap 35 with 36
        printRight(root.left, level + 1);
    }

    // Iterative
    public List<Integer> rightSideViewIterative(TreeNode root) {
        
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();
                if(i == 0){
                    result.add(curr.val);
                }
            if(curr.right != null) queue.add(curr.right); // for left view swap 58 with 57
            if(curr.left != null) queue.add(curr.left);
            }
        }
        return result;
    }
}
