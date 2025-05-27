// https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;

        for(int i = 0;i < nums.length; i++) {

            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.getFirst() + k == i) {
                dq.removeFirst();
            }

            if(i >= k - 1) {
               res[j++] =  nums[dq.getFirst()];
            }
        }
        return res;   
    }
}
