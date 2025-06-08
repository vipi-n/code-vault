//https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
