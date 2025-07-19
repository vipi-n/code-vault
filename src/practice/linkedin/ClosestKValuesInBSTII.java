// https://algo.monster/liteproblems/272
// https://www.geeksforgeeks.org/dsa/find-the-closest-binary-search-tree-value-ii/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ClosestKValuesInBSTII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // Max-heap based on the absolute difference from the target
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Larger difference comes first (max-heap)
                return Double.compare(Math.abs(o2 - target), Math.abs(o1 - target));
            }
        });

        // Traverse the tree and maintain the k closest values
        getValues(root, target, k, queue);
        return new ArrayList<>(queue);
    }

    public void getValues(TreeNode root, double target, int k, PriorityQueue<Integer> queue) { // in-order traversal
        if (root == null) {
            return;
        }

        getValues(root.left, target, k, queue);

        // If heap has less than k elements, just add
        if (queue.size() < k) {
            queue.offer(root.val);
        } else {
            // If current value is closer than the farthest in heap, replace it
            if (Math.abs(root.val - target) < Math.abs(queue.peek() - target)) {
                queue.poll();        // Remove farthest value
                queue.offer(root.val); // Add current closer value
            }
        }
        getValues(root.right, target, k, queue);
    }
}
