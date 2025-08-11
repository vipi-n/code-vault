// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// TC=O(V+E)
// SC=O(V+E)

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
         adjList.add(new ArrayList<>());   
        }
        
        for(int[] edge : edges) {
             adjList.get(edge[0]).add(edge[1]);
              adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                if(detectCycle(i, adjList, visited) == true) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        visited[src] = true;
        
        while(!queue.isEmpty()) {
            
            Pair p = queue.poll();
            int node =  p.first;
            int parent =  p.second;
           
            for(int adjNode : adjList.get(node)) {
                if(visited[adjNode] == false) {
                    visited[adjNode] = true;
                    queue.add(new Pair(adjNode, node));
                }else if (adjNode != parent) {
                    // Found a visited neighbor that's not the parent → cycle
                    return true;
                }
            }
        }
        return false;  
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
