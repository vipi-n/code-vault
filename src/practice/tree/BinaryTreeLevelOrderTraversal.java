// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
// add root and null, then check if curr is null, if yes then add a new null and create a new list, this indicate a new line now
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> temp = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() > 1) {

           TreeNode curr = queue.poll();
           if(curr == null) {
              result.add(temp);
              temp = new ArrayList<>();
              queue.add(null);
              continue;
           }
           temp.add(curr.val);

           if(curr.left != null) {
            queue.add(curr.left);
           }
           if(curr.right != null) {
            queue.add(curr.right);
           }
        }
        result.add(temp);
        return result;
        
    }
}
