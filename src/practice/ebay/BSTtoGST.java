// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

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
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        Collections.reverse(values);

        replcaeNodeVal(root, values);
        return root;
        

    }

    public void replcaeNodeVal(TreeNode root, List<Integer> values) {

        if(root == null){
            return;
        }
        replcaeNodeVal(root.left, values);
        replcaeNodeVal(root.right, values);

        int nodeSum = 0;
        for(int i : values) {
            if(i > root.val){
               nodeSum += i;
            } else {
                break;
            }
        }
        root.val += nodeSum;

    }

    public void inorder(TreeNode root, List<Integer> values) {

        if(root == null) {
            return;
        }
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);

    }
}

//

class Solution {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
       
        transform(root);
        return root;
    }

    public void transform(TreeNode root) {

        if(root == null){
            return;
        }

        transform(root.right);
        sum += root.val;
        root.val = sum;  
        transform(root.left);
    }
}
