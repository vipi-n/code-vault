// https://leetcode.com/problems/n-queens/description/
// TC O(N!)
// CS O(N^2)
class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        int col = 0;

        solve(col, res, board, leftRow, lowerDiagonal, upperDiagonal, n);
        return res;
    }

    public void solve(int col,List<List<String>> res,  char[][] board, int[] leftRow, int[] lowerDiagonal,int[] upperDiagonal, int n) {
         
         if(col == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
         }

         for(int row = 0; row < n; row++) {

            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, res, board, leftRow, lowerDiagonal, upperDiagonal, n);

                // backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
         }
    }
}
