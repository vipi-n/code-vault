package practice.tree.traversal;

// TC - O(n)
// SC - O(height)
public class InorderTraversal {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);

        inOrder(root);
    }
    public static void inOrder(Node root){

        if (root != null){
            inOrder(root.left);
            System.out.print(" " +root.key);
            inOrder(root.right);
        }
    }
}


