// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

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

    // Encodes a tree to a single string.

    private static final String spliter = ",";
    private static final String NN = "X";

    public String serialize(TreeNode root) {

        StringBuilder str = new StringBuilder();
        buildString(root, str);
        return str.toString();
        
    }

    private void buildString(TreeNode node, StringBuilder str) {
        if(node == null) {
            str.append(NN).append(spliter);
        } else {
            str.append(node.val).append(spliter);
            buildString(node.left, str);
            buildString(node.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);  
    }

    private TreeNode buildTree(Queue<String> nodes) {
        
        String val = nodes.poll();
        if(val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
