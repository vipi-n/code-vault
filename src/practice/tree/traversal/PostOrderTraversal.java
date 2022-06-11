package practice.tree.traversal;

public class PostOrderTraversal {

    public static void main(String[] args) {

        Node root  = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        postOrder(root);

    }

    public static void postOrder(Node root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }

    }
}
