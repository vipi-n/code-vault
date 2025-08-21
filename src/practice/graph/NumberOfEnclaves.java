// https://leetcode.com/problems/number-of-enclaves/

// TC : O(m * n)
class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[] row = {0, 0, -1, 1};
        int[] col = {-1, 1, 0, 0};

        int[][] visited = new int[m][n];
        
        // Top row and bottom row
        for(int j = 0; j < n; j++) {
            if(grid[0][j] == 1 && visited[0][j] == 0) {
                dfs(0, j, grid, visited, row, col);
            }
            if(grid[m - 1][j] == 1 && visited[m - 1][j] == 0) {
                dfs(m - 1, j, grid, visited, row, col);
            }
        }

        // Left col and right col
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1 && visited[i][0] == 0) {
                dfs(i, 0, grid, visited, row, col);
            }
            if(grid[i][n - 1] == 1 && visited[i][n - 1] == 0) {
                dfs(i, n - 1, grid, visited, row, col);
            }
        }

        // Count enclaves
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] grid, int[][] visited, int[] delRow, int[] delCol) {
        visited[row][col] = 1;

        int m = grid.length;
        int n = grid[0].length;

        for(int k = 0; k < 4; k++) {
            int drow = row + delRow[k];
            int dcol = col + delCol[k];

            if(drow >= 0 && drow < m && dcol >= 0 && dcol < n &&
               visited[drow][dcol] == 0 && grid[drow][dcol] == 1) {
                dfs(drow, dcol, grid, visited, delRow, delCol);
            }
        }
    }
}
