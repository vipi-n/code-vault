package practice.tree;

//TC O(n)
// SC O(height + 1)
public class BinaryTreeHeight {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);

        int height = heightOfTree(root);
        System.out.println("height  is :" +height);

    }
    private static int heightOfTree(Node root) {
        if (root == null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

}
