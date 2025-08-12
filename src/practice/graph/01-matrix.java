// https://leetcode.com/problems/01-matrix/description/
// tc : O(m × n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    vis[i][j] = true;
                    queue.add(new int[] { i, j });
                }
            }
        }
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };// up, left, right, down
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {
                int newr = r + d[0];
                int newc = c + d[1];

                if (newr >= 0 && newr < m && newc >= 0 && newc < n && !vis[newr][newc]) {
                    vis[newr][newc] = true;
                    res[newr][newc] = res[r][c] + 1;
                    queue.add(new int[] { newr, newc });
                }
            }
        }
        return res;
    }
}
