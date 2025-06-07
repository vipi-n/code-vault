//https://leetcode.com/problems/last-stone-weight/

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones) {
            q.add(i);
        }
        
        int first = 0;
        int second = 0;
        while(q.size() > 1) {
            first = q.poll();
            second = q.poll();
            q.add(first - second);
        }
        return q.peek();
    }
}
