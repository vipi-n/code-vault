// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1&selectedLang=python3

class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
       
       ArrayList<String> res = new ArrayList<>();
       StringBuilder s = new StringBuilder();
       int n = maze.length;
       boolean [][]visited = new boolean[n][n];
       solve(0, 0, n, maze, res, s,visited);
       return res;
        
    }
    
    private void solve(int i, int j, int n, int[][] maze, ArrayList<String> res, StringBuilder s, boolean [][]visited) {
        
        
        if(i == n - 1 && j == n - 1) {
            res.add(new StringBuilder(s).toString());
        }
        
        // D L R U
        // Down
        if(i + 1 < n && !visited[i + 1][j] && maze[i + 1][j] == 1) {
            visited[i][j] = true;
            s.append("D");
            solve(i + 1, j, n, maze, res, s, visited);
            visited[i][j] = false;
             s.deleteCharAt(s.length() - 1);
        }
        // Left
        if(j - 1 >= 0 && !visited[i][j - 1] && maze[i][j - 1] == 1) {
            visited[i][j] = true;
            s.append("L");
            solve(i, j - 1, n, maze, res, s, visited);
            visited[i][j] = false;
            s.deleteCharAt(s.length() - 1);
        }
        // Right
        if(j + 1 < n && !visited[i][j + 1] && maze[i][j + 1] == 1) {
            visited[i][j] = true;
            s.append("R");
            solve(i, j + 1, n, maze, res, s, visited);
            visited[i][j] = false;
            s.deleteCharAt(s.length() - 1);
        }
        
        // Up
        if(i - 1 >= 0 && !visited[i - 1][j] && maze[i - 1][j] == 1) {
            visited[i][j] = true;
            s.append("U");
            solve(i - 1, j, n, maze, res, s, visited);
            visited[i][j] = false;
            s.deleteCharAt(s.length() - 1);
        }
    }
}
