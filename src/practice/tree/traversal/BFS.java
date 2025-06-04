// TC = Theta(N) / O(N)
// SC = Theta(W), W is the width of the BT

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(7);
        node.left.left = new Node(4);
        printLevel(node);

    }

    public static void printLevel(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.key); // 2, 3, 4, 7
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
class Node {
    int key;
    Node left;
    Node right;

    Node (int key) {
        this.key = key;
    }
}
