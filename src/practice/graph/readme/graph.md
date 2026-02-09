# Graph Data Structure — Complete Guide

## Table of Contents

- [What is a Graph?](#what-is-a-graph)
- [Vertex and Edge](#vertex-and-edge)
- [Types of Graphs](#types-of-graphs)
- [Graph Representations](#graph-representations)
- [Input Formats in Problems](#input-formats-in-problems)
- [Building Adjacency List](#building-adjacency-list)
- [BFS and DFS Traversal](#bfs-and-dfs-traversal)
- [Visited Array — Why We Need It](#visited-array--why-we-need-it)
- [Cycle Detection](#cycle-detection)
- [Common Problem Patterns](#common-problem-patterns)
- [Time and Space Complexity](#time-and-space-complexity)
- [Template Code](#template-code)

---

## What is a Graph?

A graph is a collection of **nodes (vertices)** connected by **edges (links)**.

```
    0 --- 1
    |     |
    2 --- 3

Vertices: {0, 1, 2, 3}
Edges:    {(0,1), (0,2), (1,3), (2,3)}
```

### Real-World Examples

| Graph         | Vertices       | Edges              |
| ------------- | -------------- | ------------------ |
| Social Network | People        | Friendships        |
| Google Maps   | Cities         | Roads              |
| Internet      | Web pages      | Hyperlinks         |
| Course Plan   | Courses        | Prerequisites      |

---

## Vertex and Edge

### Vertex (Node)

A **vertex** is a point/entity in the graph — the "things" you're connecting.

### Edge

An **edge** is a connection/link between two vertices — the "relationships."

### Degree

The **degree** of a vertex = number of edges connected to it.

```
    A --- B --- C
    |
    D

Degree of A = 2 (connected to B and D)
Degree of B = 2 (connected to A and C)
Degree of C = 1 (connected to B only)
Degree of D = 1 (connected to A only)
```

### In-Degree and Out-Degree (Directed Graphs)

```
    A → B → C
    ↑       |
    D ←-----+

In-degree of A  = 0 (no one points to A)
Out-degree of A = 1 (A points to B)
In-degree of B  = 1 (A points to B)
Out-degree of B = 1 (B points to C)
```

---

## Types of Graphs

### 1. Undirected Graph

Edges have **no direction**. If A connects to B, then B connects to A.

```
    A --- B
    |     |
    C --- D

Edge (A,B) = Edge (B,A)
```

### 2. Directed Graph (Digraph)

Edges have a **direction**. A → B does NOT mean B → A.

```
    A → B
    ↑   ↓
    D ← C

A → B exists, but B → A does NOT
```

### 3. Weighted Graph

Edges have a **weight/cost** (distance, time, etc.).

```
    A --5-- B
    |       |
    3       2
    |       |
    C --1-- D
```

### 4. Unweighted Graph

All edges have **equal weight** (or weight = 1).

### 5. Cyclic vs Acyclic

```
Cyclic (has cycle):        Acyclic (no cycle):
    A --- B                    A → B
    |     |                    ↓   ↓
    C --- D                    C   D
    
DAG = Directed Acyclic Graph (very common in problems)
```

### 6. Connected vs Disconnected

```
Connected:                 Disconnected:
    A --- B                    A --- B     C --- D
    |     |                    
    C --- D                    (Two separate components)
```

### Summary Table

| Type           | Direction | Weight  | Example                   |
| -------------- | --------- | ------- | ------------------------- |
| Undirected     | No        | No      | Facebook friends          |
| Directed       | Yes       | No      | Twitter followers         |
| Weighted       | Either    | Yes     | Google Maps (distances)   |
| DAG            | Yes       | Either  | Course prerequisites      |
| Tree           | Either    | Either  | File system               |

---

## Graph Representations

### 1. Edge List

A simple list of all edges.

```java
int[][] edges = {
    {0, 1},    // edge from 0 to 1
    {0, 2},    // edge from 0 to 2
    {1, 3},    // edge from 1 to 3
    {2, 3}     // edge from 2 to 3
};
// Shape: E × 2 (always 2 columns)
```

**When you get it:** Problem gives you number of nodes + list of connections.

### 2. Adjacency List

For each node, a list of its neighbors.

```java
// adjList[0] = [1, 2]     → Node 0 connects to 1, 2
// adjList[1] = [0, 3]     → Node 1 connects to 0, 3
// adjList[2] = [0, 3]     → Node 2 connects to 0, 3
// adjList[3] = [1, 2]     → Node 3 connects to 1, 2
```

**When you get it:** Some problems give this directly.

### 3. Adjacency Matrix

A V × V matrix where `matrix[i][j] = 1` means edge from i to j.

```java
int[][] matrix = {
    {0, 1, 1, 0},   // Node 0 → connects to 1, 2
    {1, 0, 0, 1},   // Node 1 → connects to 0, 3
    {1, 0, 0, 1},   // Node 2 → connects to 0, 3
    {0, 1, 1, 0}    // Node 3 → connects to 1, 2
};
```

### 4. Grid (2D Matrix)

A grid where each cell is a node, and neighbors are up/down/left/right.

```java
int[][] grid = {
    {1, 1, 0},
    {1, 0, 0},
    {0, 0, 1}
};
// Cell (0,0) is a node, neighbors = (0,1) and (1,0)
```

**When you get it:** Island problems, maze problems, flood fill.

### Comparison

| Representation    | Space   | Find Neighbors | Check Edge Exists | Best For              |
| ----------------- | ------- | -------------- | ----------------- | --------------------- |
| Edge List         | O(E)    | O(E)           | O(E)              | Input format          |
| Adjacency List    | O(V+E)  | O(degree)      | O(degree)         | BFS/DFS (most common) |
| Adjacency Matrix  | O(V²)   | O(V)           | O(1)              | Dense graphs          |
| Grid              | O(M×N)  | O(1) (4 dirs)  | O(1)              | 2D maze/island        |

---

## Input Formats in Problems

### Format 1: Edge List (Most Common)

```
Input: n = 4, edges = [[0,1], [0,2], [1,3], [2,3]]

→ Convert to adjacency list, then BFS/DFS
```

### Format 2: Adjacency List (Given Directly)

```
Input: adjList = [[1,2], [0,3], [0,3], [1,2]]

→ Use directly for BFS/DFS
```

### Format 3: Grid

```
Input: grid = [[1,1,0],
               [1,0,0],
               [0,0,1]]

→ Use direction array, no adjacency list needed
```

### Format 4: Edge List with Weights

```
Input: edges = [[0,1,5], [0,2,3], [1,3,2]]
                         ↑
                       weight

→ Use int[] pair {neighbor, weight} in adjacency list
```

### Format 5: Number of Nodes + Edges (Course Schedule Style)

```
Input: numCourses = 4, prerequisites = [[1,0], [2,1], [3,2]]
       Meaning: To take course 1, you need course 0 first → 0 → 1

→ Directed graph, build adjacency list
```

---

## Building Adjacency List

### From Edge List — Undirected

```java
int V = 4;
int[][] edges = {{0,1}, {0,2}, {1,3}, {2,3}};

List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

for (int[] edge : edges) {
    adj.get(edge[0]).add(edge[1]);   // both directions
    adj.get(edge[1]).add(edge[0]);   // for undirected
}
```

### From Edge List — Directed

```java
for (int[] edge : edges) {
    adj.get(edge[0]).add(edge[1]);   // one direction only
}
```

### From Edge List — Weighted

```java
List<List<int[]>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

for (int[] edge : edges) {
    adj.get(edge[0]).add(new int[]{edge[1], edge[2]});  // {neighbor, weight}
    adj.get(edge[1]).add(new int[]{edge[0], edge[2]});  // undirected
}
```

### Grid — No Adjacency List Needed

```java
// Use direction arrays instead
int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};  // up, down, left, right

for (int[] dir : dirs) {
    int newRow = row + dir[0];
    int newCol = col + dir[1];
    
    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
        // (newRow, newCol) is a valid neighbor
    }
}
```

---

## BFS and DFS Traversal

### BFS (Breadth-First Search)

Explores **level by level** (all neighbors first, then their neighbors).

Think: **ripple effect in water** — spreads outward evenly.

```java
public List<Integer> bfs(List<List<Integer>> adj, int start) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
    return result;
}
```

**Use BFS when:** Minimum steps, shortest path (unweighted), level-order.

### DFS (Depth-First Search)

Explores **as deep as possible** first, then backtracks.

Think: **going down a tunnel** — go all the way, then come back and try another.

```java
public List<Integer> dfs(List<List<Integer>> adj, int start) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    dfsHelper(adj, start, visited, result);
    return result;
}

private void dfsHelper(List<List<Integer>> adj, int node, 
                       boolean[] visited, List<Integer> result) {
    visited[node] = true;
    result.add(node);
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfsHelper(adj, neighbor, visited, result);
        }
    }
}
```

**Use DFS when:** Find any path, detect cycles, explore all possibilities.

### BFS vs DFS

| Aspect              | BFS              | DFS              |
| ------------------- | ---------------- | ---------------- |
| Data Structure      | Queue            | Stack (recursion) |
| Exploration         | Level by level   | Deep then backtrack |
| Shortest Path       | ✅ Yes           | ❌ No            |
| Memory              | O(V) — can be high | O(V) — call stack |
| Use Case            | Shortest path    | Cycle detection, paths |

### BFS on Grid

```java
public void bfsGrid(int[][] grid, int startRow, int startCol) {
    int m = grid.length, n = grid[0].length;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    
    queue.offer(new int[]{startRow, startCol});
    visited[startRow][startCol] = true;
    
    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        
        for (int[] dir : dirs) {
            int nr = curr[0] + dir[0];
            int nc = curr[1] + dir[1];
            
            if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                && !visited[nr][nc] && grid[nr][nc] == 1) {
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
```

### DFS on Grid

```java
public void dfsGrid(int[][] grid, int row, int col, boolean[][] visited) {
    int m = grid.length, n = grid[0].length;
    
    if (row < 0 || row >= m || col < 0 || col >= n 
        || visited[row][col] || grid[row][col] == 0) {
        return;
    }
    
    visited[row][col] = true;
    
    dfsGrid(grid, row + 1, col, visited);  // down
    dfsGrid(grid, row - 1, col, visited);  // up
    dfsGrid(grid, row, col + 1, visited);  // right
    dfsGrid(grid, row, col - 1, visited);  // left
}
```

---

## Visited Array — Why We Need It

### Purpose: Prevent Infinite Loops

Without `visited`, DFS/BFS loops forever:

```
0 → 1 → 0 → 1 → 0 → 1 ... INFINITE LOOP 💀
```

With `visited`:

```
Visit 0 → Visit 1 → See 0 (visited, skip!) → DONE ✅
```

### Different Uses of Visited

| Context            | What `visited` Does                      |
| ------------------ | ---------------------------------------- |
| Traversal          | Don't visit same node twice              |
| Shortest Path      | Don't re-process already-reached nodes   |
| Cycle Detection    | Detect if we've been here before         |
| Grid Problems      | Sometimes use `grid[r][c] = 0` instead  |

---

## Cycle Detection

### Undirected Graph — Track Parent

```java
// Cycle = visited neighbor that is NOT the parent

private boolean dfs(List<List<Integer>> adj, int node, int parent, boolean[] visited) {
    visited[node] = true;
    
    for (int neighbor : adj.get(node)) {
        if (neighbor == parent) continue;        // skip parent
        if (visited[neighbor]) return true;      // CYCLE!
        if (dfs(adj, neighbor, node, visited)) return true;
    }
    return false;
}
```

**Key insight:** In undirected graph, if a visited neighbor is NOT the parent → there's another path to it → **CYCLE**.

### Directed Graph — Track Recursion Stack

```java
// Cycle = neighbor is in the current DFS path (recursion stack)

private boolean dfs(List<List<Integer>> adj, int node, 
                    boolean[] visited, boolean[] inRecStack) {
    visited[node] = true;
    inRecStack[node] = true;        // currently exploring this path
    
    for (int neighbor : adj.get(node)) {
        if (inRecStack[neighbor]) return true;   // CYCLE!
        if (!visited[neighbor]) {
            if (dfs(adj, neighbor, visited, inRecStack)) return true;
        }
    }
    
    inRecStack[node] = false;       // backtrack
    return false;
}
```

**Key insight:** `visited` alone is NOT enough for directed graphs. A node visited from a **different path** is not a cycle. Only a node in the **current path** (`inRecStack`) means cycle.

### Three States in Directed Graph

```
State 1: visited=false, inRecStack=false  → Not seen     → EXPLORE
State 2: visited=true,  inRecStack=true   → Current path → CYCLE!
State 3: visited=true,  inRecStack=false  → Fully done   → SKIP
```

### Cycle Detection Comparison

| Aspect          | Undirected                 | Directed                        |
| --------------- | -------------------------- | ------------------------------- |
| Extra tracking  | `parent`                   | `inRecStack[]`                  |
| Cycle condition | `visited && != parent`     | `inRecStack[neighbor] == true`  |
| Edge direction  | Add both ways              | Add one way                     |
| Backtrack       | Not needed                 | `inRecStack[node] = false`      |

---

## Common Problem Patterns

### Pattern 1: Traversal (Visit All Nodes)

**Problems:** DFS/BFS traversal, connected components.

```java
for (int i = 0; i < V; i++) {
    if (!visited[i]) {
        dfs(adj, i, visited);
        components++;  // each unvisited start = new component
    }
}
```

### Pattern 2: Shortest Path (Unweighted)

**Problems:** Minimum steps, shortest distance, open the lock.

```java
// BFS — level by level
int level = 0;
while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (curr.equals(target)) return level;
        // add neighbors
    }
    level++;
}
```

### Pattern 3: Island/Region Problems (Grid)

**Problems:** Number of islands, flood fill, surrounded regions.

```java
int count = 0;
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
            dfs(grid, i, j);  // sink the entire island
            count++;
        }
    }
}
```

### Pattern 4: Topological Sort (DAG)

**Problems:** Course schedule, task ordering, build order.

```java
// Kahn's Algorithm (BFS)
Queue<Integer> queue = new LinkedList<>();
for (int i = 0; i < V; i++) {
    if (inDegree[i] == 0) queue.offer(i);
}
while (!queue.isEmpty()) {
    int node = queue.poll();
    result.add(node);
    for (int neighbor : adj.get(node)) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) queue.offer(neighbor);
    }
}
```

### Pattern 5: Shortest Path (Weighted)

**Problems:** Network delay, cheapest flights, path with minimum effort.

```java
// Dijkstra's Algorithm
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
pq.offer(new int[]{start, 0});

while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int node = curr[0], dist = curr[1];
    
    if (dist > distance[node]) continue;
    
    for (int[] neighbor : adj.get(node)) {
        int newDist = dist + neighbor[1];
        if (newDist < distance[neighbor[0]]) {
            distance[neighbor[0]] = newDist;
            pq.offer(new int[]{neighbor[0], newDist});
        }
    }
}
```

### Pattern 6: Union-Find

**Problems:** Redundant connection, accounts merge, number of provinces.

```java
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
}

void union(int x, int y) {
    int rootX = find(x), rootY = find(y);
    if (rootX != rootY) parent[rootX] = rootY;
}
```

### Quick Pattern Recognition

| Problem Says...                     | Use...                           |
| ----------------------------------- | -------------------------------- |
| "Minimum steps/turns/moves"         | BFS                              |
| "Number of islands/components"      | DFS/BFS on grid                  |
| "Can we finish all courses?"        | Topological Sort / Cycle Detection |
| "Shortest path with weights"        | Dijkstra                         |
| "Is the graph a valid tree?"        | Cycle Detection + Connectivity   |
| "Find redundant edge"              | Union-Find                       |
| "Clone/Copy a graph"               | BFS/DFS + HashMap                |
| "Bipartite check"                  | BFS/DFS with coloring            |

---

## Time and Space Complexity

### Traversal (BFS/DFS)

| Metric   | Adjacency List | Grid        |
| -------- | -------------- | ----------- |
| **Time** | O(V + E)       | O(M × N)    |
| **Space** | O(V)          | O(M × N)    |

### Why O(V + E)?

```
V = visiting each vertex once
E = checking each edge once

Total work = V + E
```

### Cycle Detection

| Method                   | Time      | Space     |
| ------------------------ | --------- | --------- |
| DFS (Undirected)         | O(V + E)  | O(V)      |
| DFS (Directed)           | O(V + E)  | O(V)      |
| BFS (Undirected)         | O(V + E)  | O(V)      |
| Union-Find               | O(E × α(V)) ≈ O(E) | O(V) |

### Shortest Path Algorithms

| Algorithm    | Time              | Space   | Use Case            |
| ------------ | ----------------- | ------- | ------------------- |
| BFS          | O(V + E)          | O(V)    | Unweighted          |
| Dijkstra     | O((V+E) log V)    | O(V)    | Non-negative weights |
| Bellman-Ford | O(V × E)          | O(V)    | Negative weights     |
| Floyd-Warshall | O(V³)           | O(V²)  | All pairs            |

---

## Template Code

### Universal Graph Setup

```java
// Step 1: Build adjacency list
int V = n;  // number of vertices
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

// Step 2: Fill from edges
for (int[] edge : edges) {
    adj.get(edge[0]).add(edge[1]);
    adj.get(edge[1]).add(edge[0]);  // remove for directed
}

// Step 3: Traverse (handle disconnected graphs)
boolean[] visited = new boolean[V];
for (int i = 0; i < V; i++) {
    if (!visited[i]) {
        bfs(adj, i, visited);  // or dfs
    }
}
```

### BFS Template

```java
private void bfs(List<List<Integer>> adj, int start, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### DFS Template

```java
private void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
    visited[node] = true;
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(adj, neighbor, visited);
        }
    }
}
```

### Grid DFS Template

```java
int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
    int m = grid.length, n = grid[0].length;
    
    if (row < 0 || row >= m || col < 0 || col >= n 
        || visited[row][col] || grid[row][col] == 0) {
        return;
    }
    
    visited[row][col] = true;
    
    for (int[] dir : dirs) {
        dfs(grid, row + dir[0], col + dir[1], visited);
    }
}
```

### Grid BFS Template

```java
int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

private void bfs(int[][] grid, int startRow, int startCol) {
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    
    queue.offer(new int[]{startRow, startCol});
    visited[startRow][startCol] = true;
    
    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        
        for (int[] dir : dirs) {
            int nr = curr[0] + dir[0];
            int nc = curr[1] + dir[1];
            
            if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                && !visited[nr][nc] && grid[nr][nc] == 1) {
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
```

---

## Must-Solve LeetCode Problems

| #   | Problem                              | Pattern             | Difficulty |
| --- | ------------------------------------ | ------------------- | ---------- |
| 200 | Number of Islands                    | Grid DFS/BFS        | Medium     |
| 733 | Flood Fill                           | Grid DFS            | Easy       |
| 994 | Rotting Oranges                      | Grid BFS (multi)    | Medium     |
| 207 | Course Schedule                      | Cycle Detection     | Medium     |
| 210 | Course Schedule II                   | Topological Sort    | Medium     |
| 133 | Clone Graph                          | DFS + HashMap       | Medium     |
| 752 | Open the Lock                        | BFS Shortest Path   | Medium     |
| 127 | Word Ladder                          | BFS Shortest Path   | Hard       |
| 743 | Network Delay Time                   | Dijkstra            | Medium     |
| 684 | Redundant Connection                 | Union-Find          | Medium     |
| 785 | Is Graph Bipartite?                  | BFS/DFS Coloring    | Medium     |
| 261 | Graph Valid Tree                     | Cycle + Connectivity| Medium     |
| 323 | Number of Connected Components       | DFS/Union-Find      | Medium     |
| 417 | Pacific Atlantic Water Flow          | Multi-source DFS    | Medium     |
| 1091| Shortest Path in Binary Matrix       | BFS                 | Medium     |
