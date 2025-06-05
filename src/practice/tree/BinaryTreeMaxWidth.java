// https://www.geeksforgeeks.org/problems/maximum-width-of-tree/1

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class BinaryTreeMaxWidth {
    int getMaxWidth(Node root) {
        
        if(root == null) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        
        while(!queue.isEmpty()) {
           
            int size = queue.size();
            int count = 0;
            
            for(int i = 0; i < size; i++) {
                Node curr = queue.poll();
                count++;
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            result = Math.max(result, count);
        }
        return result;   
    }
}
