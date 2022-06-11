package practice.tree;

public class BinaryTree {

   public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
    }
}

class Node{

    int key;
    Node left;
    Node right;

    Node(int k){
        key = k;
    }
}
