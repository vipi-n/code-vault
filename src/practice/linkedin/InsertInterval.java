// https://leetcode.com/problems/insert-interval/
// Related - https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[intervals.length] = newInterval;

        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] newInt = newIntervals[0];

        for (int i = 1; i < newIntervals.length; i++) {

            if (newInt[1] >= newIntervals[i][0]) {
                newInt[1] = Math.max(newInt[1], newIntervals[i][1]);
            } else {
                list.add(newInt);
                newInt = newIntervals[i];
            }
        }
        list.add(newInt);
        return list.toArray(new int[list.size()][]);
    }
}
