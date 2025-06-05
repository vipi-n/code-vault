// https://leetcode.com/problems/root-equals-sum-of-children/
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
    public boolean checkTree(TreeNode root) {

        if(root == null || root.left == null || root.right== null) return false;

        if(root.val == root.left.val + root.right.val) {
            return true;
        }

        return checkTree(root.left) && checkTree(root.right);
    }

 // only below required for this Q

 public boolean checkTreeThis(TreeNode root) {

        return root.val == root.left.val + root.right.val;
    }

 // GFG Question, notmal tree not only 3 nodes

    public static boolean isCSum(Node root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        int sum=0;
        if(root.left!=null)sum+=root.left.key;
        if(root.right!=null)sum+=root.right.key;
        
        return (root.key==sum && isCSum(root.left) && isCSum(root.right));
   
}
