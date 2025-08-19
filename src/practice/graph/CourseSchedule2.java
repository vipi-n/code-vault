// https://leetcode.com/problems/course-schedule-ii/description/
// TC : O(V + E)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
              adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[numCourses];  // 0=unvisited, 1=visiting, 2=done

        for(int i = 0; i < numCourses; i++) {
              if(visited[i] == 0) {
                if (!dfs(i, adjList, visited, stack)) {
                    return new int[0]; // cycle detected → no valid order
                }
            }
        }

        int j = 0;
        int[] res = new int[numCourses];
        while(!stack.isEmpty()) {
            res[j++] = stack.pop();
        }

        return res;
    }

    private boolean dfs(int node, List<ArrayList<Integer>> adjList, int[] visited, Stack<Integer> stack) {

       visited[node] = 1; // mark as visiting

        for (int i : adjList.get(node)) {
            if (visited[i] == 1) {
                return false; // cycle detected
            }
            if (visited[i] == 0) {
                if(!dfs(i, adjList, visited, stack)) {
                    return false;
                }
            }
        }
        visited[node] = 2; // mark as done
        stack.push(node);
        return true;
    }
}

