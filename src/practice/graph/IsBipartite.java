// https://leetcode.com/problems/is-graph-bipartite/description/
// TC : O(V+E)
// SC : O(V)

class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, graph)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean bfs(int start, int color[], int[][] graph) {

        color[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph[node]) {
                if (color[i] == color[node]) {
                    return false;
                } else if (color[i] == -1) {
                    color[i] = 1 - color[node];
                    queue.add(i);
                }
            }
        }
        return true;
    }
}
