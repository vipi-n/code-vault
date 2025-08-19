// https://www.geeksforgeeks.org/problems/topological-sort/1
// TC : O(V + E)
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int j = 0;

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void dfs(int node, List<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for(int i : adjList.get(node)) {
            if(!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }
        stack.push(node);
    }
}
