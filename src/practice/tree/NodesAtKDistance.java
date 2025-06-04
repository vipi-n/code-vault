// https://www.geeksforgeeks.org/problems/k-distance-from-root/1

public class NodesAtKDistance {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(7);
        node.left.left = new Node(4);
        printRootKey(node, 3);

    }

    public static void printRootKey(Node root, int k) {

        if (root == null) return;

        if (k == 0) {
            System.out.println(root.key);
        } else {
            printRootKey(root.left, k - 1);
            printRootKey(root.right, k - 1);
        }
    }
}
