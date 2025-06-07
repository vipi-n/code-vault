// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest {

    int k = 0;
    int[] nums;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {

        queue.add(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();    
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
