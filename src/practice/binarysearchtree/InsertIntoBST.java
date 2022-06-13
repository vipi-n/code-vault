package practice.binarysearchtree;

public class InsertIntoBST {
    public static void main(String[] args) {

        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);

        int x = 15;
        traverse(root);
        Node newNode = insert(root, x);
        System.out.println("newNode's key " + newNode);
    }

    public static Node insert(Node root, int x){
        Node toInsert = new Node(x);
        if (root == null) {
            return new Node(x);
        }
        if (root == toInsert) return root;
        else if (root.key < x) root.right = insert(root.right, x);
        else if (root.key > x) root.left =  insert(root.left, x);
        return root;
    }

    public static void traverse(Node root){

        if (root != null){
            traverse(root.left);
            System.out.print(" " +root.key);
            traverse(root.right);
        }
    }
}
