// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
//TC : O(V + 2E)
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int V = adj.size();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis  = new boolean[V];
        dfsGraph(0,adj, list, vis);
        return list;
    }
    
    public void dfsGraph(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, boolean[] vis) {
        
        vis[node] = true;
        list.add(node);
        
        for(int i : adj.get(node)) {
            if(!vis[i]) {
               dfsGraph(i, adj,list, vis); 
            }
        }
        
    }
}
