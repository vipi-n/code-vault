// https://leetcode.com/problems/valid-sudoku/description/

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // A set to keep track of the seen numbers in rows, columns, and 3x3 blocks
        Set<String> seen = new HashSet<>();

        // Traverse every cell in the 9x9 board
        for (int i = 0; i < 9; i++) {         
            for (int j = 0; j < 9; j++) {     
                char number = board[i][j];

                // Skip empty cells
                if (number != '.') {
                    // Build strings to represent the state
                    String rowKey = number + " in row " + i;
                    String colKey = number + " in column " + j;
                    String blockKey = number + " in block " + (i / 3) + "-" + (j / 3);

                    // If any of the strings already exist in the set, the board is invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(blockKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
