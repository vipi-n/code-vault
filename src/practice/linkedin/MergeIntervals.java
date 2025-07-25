//https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                list.add(newInterval);
                newInterval = intervals[i];
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
