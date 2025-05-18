// https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            pq.add(new int[] {m.getKey(), m.getValue()});
        }

        int[] res = new int[k];
        
        while(k > 0) {
           res[k - 1] = pq.poll()[0];
           k--;  
        }
        return res;
        
    }
}
