// https://leetcode.com/problems/sudoku-solver/description/class Solution {
    
public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, ch, i, j)) {
                            board[i][j] = ch;
                            if (solve(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, char ch, int row, int col) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;

            if (board[row][i] == ch)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)

                return false;
        }
        return true;
    }

}
