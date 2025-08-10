// https://leetcode.com/problems/flood-fill/
// https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1

// TC and SC -  O(n×m)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        bfs(image, vis, sr, sc, color, originalColor);
        return image;
    }

    private void bfs(int[][] image, int[][] vis, int sr, int sc, int newColor, int originalColor) {

        int n = image.length;
        int m = image[0].length;
        vis[sr][sc] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor;

        int[] dr = { 0, 1, 0, -1 }; // left, down, right, up
        int[] dc = { -1, 0, 1, 0 };

        while (!queue.isEmpty()) {

            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && vis[newRow][newCol] == 0 && image[newRow][newCol] == originalColor) {
                    vis[newRow][newCol] = 1;
                    image[newRow][newCol] = newColor;
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

// without vis[][]

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;
        bfs(image, sr, sc, color, originalColor);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int newColor, int originalColor) {

        int n = image.length;
        int m = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor;

        int[] dr = { 0, 1, 0, -1 }; // left, down, right, up
        int[] dc = { -1, 0, 1, 0 };

        while (!queue.isEmpty()) {

            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                         && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = newColor;
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

