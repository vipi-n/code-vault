// https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (vis[i][j] != 1 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();

            int[] dr = { -1, 0, 1, 0 }; // up, right, down, left
            int[] dc = { 0, 1, 0, -1 };

            for (int k = 0; k < 4; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && vis[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                    vis[newRow][newCol] = 1;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
