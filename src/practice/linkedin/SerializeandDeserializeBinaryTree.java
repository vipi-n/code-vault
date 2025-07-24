// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        buildString(root, str);
        return str.toString();
    }

    public void buildString(TreeNode root, StringBuilder str) {

        if (root == null) {
            str.append(NN).append(spliter);
        }else {
        str.append(root.val).append(spliter);
        buildString(root.left, str);
        buildString(root.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue) {

        String s = queue.poll();
        if (s.equals(NN))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

