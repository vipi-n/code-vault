package practice.binarysearchtree;

public class SearchInBST {

    public static void main(String[] args) {

        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);

        int x = 16;
        boolean result = searchRecursive(root, x);
        System.out.println(result);
        System.out.println(searchIterative(root, x));
    }

    public static boolean searchRecursive(Node root, int x){

        if (root == null) return false;
        if (root.key == x) return true;
        else if (x < root.key) return searchRecursive(root.left, x);
        else return searchRecursive(root.right, x);

    }

    public static boolean searchIterative(Node root, int x){

        while (root != null){
            if (root == null) return false;
            if (root.key == x) return true;
            else if (x < root.key) root = root.left;
            else root = root.right;
        }
        return false;
    }
}

class Node{
    Node left;
    Node right;
    int key;

    Node(int key){
        this.key = key;
    }
}
