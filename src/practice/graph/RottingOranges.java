// https://leetcode.com/problems/rotting-oranges/
// TC and SC : O(m × n)

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                     fresh++;
                }
            }
        }
        if (fresh == 0) return 0; 
        return bfs(grid, queue, fresh);
    }

    private int bfs(int[][] grid, Queue<Pair> queue, int fresh) {

        int m = grid.length;
        int n = grid[0].length;
        int minutes = -1;

        int[] dr = { 0, 1, 0, -1 }; // left, low, right, up
        int[] dc = { -1, 0, 1, 0 };

        while (!queue.isEmpty()) {

            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {

                Pair curr = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int newRow = curr.first + dr[k];
                    int newCol = curr.second + dc[k];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new Pair(newRow, newCol));
                        fresh--;
                    }
                }
            }

        }
         return fresh == 0 ? minutes : -1;
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
