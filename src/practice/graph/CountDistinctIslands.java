// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
// TC : O(n * m)
// SC = O(m × n)

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
       
       int m = grid.length;
       int n = grid[0].length;
       boolean[][] visited = new boolean[m][n]; 
       
       Set<ArrayList<String>> set = new HashSet<>();
       
       for(int i = 0; i < m; i++) {
           for(int j = 0; j < n; j++) {
               
               if(!visited[i][j] && grid[i][j] == 1) {
                   ArrayList<String> list = new ArrayList<>();
                   dfs(i, j, grid, visited, list, i, j);
                   set.add(list);
               }
               
           }
       }
       return set.size();
    }
    
    private void dfs(int row, int col,int[][] grid, boolean[][] visited, ArrayList<String> list, int row0, int col0) {
        
        visited[row][col] = true;
        list.add(toString(row - row0, col - col0));
      
        int m = grid.length;
        int n = grid[0].length;
        
        int[] drow = {0, 0, -1, 1};
        int[] dcol = {-1, 1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            int delRow = row + drow[i];
            int delCol = col + dcol[i];
            
            if(delRow >= 0 && delRow < m && delCol >= 0 && delCol < n
            && !visited[delRow][delCol] && grid[delRow][delCol] == 1) {
                dfs(delRow, delCol, grid, visited, list, row0, col0);
            }
            
        }
    }
    
    private String toString(int i, int j) {
        return Integer.toString(i) + " " + Integer.toString(j);
    }
}
