import java.util.LinkedList;
import java.util.Queue;

public class MaxValueInBS {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(7);
        root.left.left = new Node(40);
        System.out.println(maxRecur(root));
        System.out.println(maxIterative(root));

    }

    public static int maxRecur(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxVal = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            maxVal = Math.max(maxVal, curr.val);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
      return maxVal;
    }

    public static int maxIterative(Node root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val, Math.max(maxIterative(root.left), maxIterative(root.right)));
    }
}
class Node {
    int val;
    Node left;
    Node right;

    Node (int val) {
        this.val = val;
    }
}
