// https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = 
          new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point : points) {
            queue.add(point);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        for(int[] point : queue) {
            result[i++] = point;
        }
        return result;     
    }
}
