// https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1

class Node
class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}

// This function should return head to the DLL

class Solution {
    Node prev = null;
    Node head = null;

    Node bToDLL(Node root) {
        if (root == null) return null;

        // Step 1: Convert left subtree
        bToDLL(root.left);

        // Step 2: Process current node
        if (prev == null) {
            head = root; // First node (leftmost) becomes head
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Step 3: Convert right subtree
        bToDLL(root.right);

        return head;
    }
}

