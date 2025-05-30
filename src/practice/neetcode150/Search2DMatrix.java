// https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;

        if(row == 0 || col == 0) return false;

        int i = row - 1; // start with last row and first column, if the val at last row and first col is greater , we can ignore while row if not col++
        int j = 0;

        while(j < col && i >= 0) {

            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
