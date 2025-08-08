//https://leetcode.com/problems/number-of-provinces/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // convert adj matrix to adj list for better readability 
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int count = 0;
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
             count++;
             dfs(i, adjList, vis);;
            }
            
        } 
        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis) {

        vis[node] = 1;

        for(int val : adjList.get(node)) {
           if(vis[val] == 0) {
            dfs(val, adjList, vis);
           }
        }
    }
}
