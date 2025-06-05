public class SizeOfBS {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(7);
        node.left.left = new Node(4);
        System.out.println(size(node));
    }

    public static int size(Node root) {
        if (root == null)  return 0;
        return 1 + size(root.left) + size(root.right);
    }

  class Node {
    int key;
    Node left;
    Node right;

    Node (int key) {
        this.key = key;
    }
}
