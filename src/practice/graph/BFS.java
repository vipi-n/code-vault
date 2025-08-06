// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// TC = O(V + E)
// SC = O(V)
class BFS {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int V = adj.size();
        ArrayList<Integer> bsfList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        
        queue.add(0);
        vis[0] = true;
        
        while(!queue.isEmpty()) {
            
            int node = queue.poll();
            bsfList.add(node);
            
            for(int i : adj.get(node)) {
                if(!vis[i]) {
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
        return bsfList;
    }
}
