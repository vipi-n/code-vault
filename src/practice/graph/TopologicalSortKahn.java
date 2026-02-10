class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        int[] indegree = new int[V];
        boolean[] vis = new boolean[V];
        List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
        }

        for (List<Integer> l : list) {
            for (int i : l) {
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {

            int curr = queue.poll();
            result.add(curr);

            for (int i : list.get(curr)) {
                if (--indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return result;
    }
}
