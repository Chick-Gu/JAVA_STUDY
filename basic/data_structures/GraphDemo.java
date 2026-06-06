package data_structures;

import java.util.*;

/**
 * 图详解
 *
 * Java 标准库中没有直接提供通用图类。
 * 实际项目中通常使用第三方库 (如 JGraphT, Guava Graph)
 * 或手动实现。图的两种主要表示方式:
 *
 * 1. 邻接表 (Adjacency List) — 常用, 省空间 O(V+E)
 * 2. 邻接矩阵 (Adjacency Matrix) — 适合稠密图
 *
 * @see java.util.LinkedHashMap 可维护插入顺序的图
 * @see java.util.TreeMap 可按 key 排序存储邻接节点
 */
public class GraphDemo {

    public static void main(String[] args) {
        // ==================== 1. 图的表示 ====================
        System.out.println("=== 1. 图的两种表示 ===");

        // 邻接表
        AdjacencyListGraph graph = new AdjacencyListGraph();
        buildSampleGraph(graph);
        System.out.println("邻接表表示:");
        graph.print();

        // 邻接矩阵
        AdjacencyMatrixGraph matrixGraph = new AdjacencyMatrixGraph(5);
        buildSampleMatrix(matrixGraph);
        System.out.println("\n邻接矩阵表示:");
        matrixGraph.print();

        // ==================== 2. DFS 遍历 ====================
        System.out.println("\n=== 2. DFS (深度优先搜索) ===");
        System.out.print("递归 DFS 从 0 开始: ");
        System.out.println(graph.dfs(0));

        System.out.print("迭代 DFS (用栈) 从 0 开始: ");
        System.out.println(graph.dfsIterative(0));

        System.out.println("  用途: 路径查找、连通分量、拓扑排序、找环");

        // ==================== 3. BFS 遍历 ====================
        System.out.println("\n=== 3. BFS (广度优先搜索) ===");
        System.out.print("BFS 从 0 开始: ");
        System.out.println(graph.bfs(0));

        System.out.print("0 到 4 的最短路径: ");
        System.out.println(graph.shortestPath(0, 4));
        System.out.println("  用途: 最短路径(无权图)、社交网络中的\"N度人脉\"");

        // ==================== 4. 拓扑排序 ====================
        System.out.println("\n=== 4. 拓扑排序 (DAG) ===");
        // 构建有向无环图:  0→1→3
        //                  ↓  ↓
        //                  2→4
        AdjacencyListGraph dag = new AdjacencyListGraph(true);
        dag.addEdge(0, 1);
        dag.addEdge(0, 2);
        dag.addEdge(1, 3);
        dag.addEdge(1, 4);
        dag.addEdge(2, 4);

        System.out.println("有向无环图 (DAG):");
        dag.print();
        List<Integer> topo = dag.topologicalSort();
        System.out.println("拓扑排序结果: " + topo);
        System.out.println("  解释: 每条边 u→v 中, u 一定排在 v 前面");
        System.out.println("  应用: 课程依赖、构建系统 (make)、任务调度");

        // ==================== 5. 环检测 ====================
        System.out.println("\n=== 5. 环检测 ===");
        System.out.println("DAG 是否有环? " + dag.hasCycle());
        System.out.println("无向图是否有环? " + graph.hasCycleUndirected());

        // ==================== 6. Dijkstra 最短路径 ====================
        System.out.println("\n=== 6. Dijkstra 最短路径 (加权图) ===");
        WeightedGraph wGraph = new WeightedGraph();
        wGraph.addEdge(0, 1, 4);
        wGraph.addEdge(0, 2, 1);
        wGraph.addEdge(2, 1, 2);
        wGraph.addEdge(1, 3, 1);
        wGraph.addEdge(2, 3, 5);
        System.out.println("加权图结构:");
        wGraph.print();
        System.out.println("从 0 出发的最短距离: " +
            java.util.Arrays.toString(wGraph.dijkstra(0)));
        System.out.println("  说明: [0, 3, 1, 4] 即 0→0=0, 0→1=3, 0→2=1, 0→3=4");

        // ==================== 7. 连通分量 ====================
        System.out.println("\n=== 7. 连通分量 ===");
        AdjacencyListGraph disconnected = new AdjacencyListGraph();
        disconnected.addEdge(0, 1);
        disconnected.addEdge(2, 3);
        System.out.println("图: 0-1 (独立), 2-3 (独立)");
        System.out.println("连通分量数: " + disconnected.countConnectedComponents());

        System.out.println("\n=== 总结: 常见面试/工程场景 ===");
        System.out.println("┌─────────────┬─────────────────────────┐");
        System.out.println("│ 场景         │ 算法                      │");
        System.out.println("├─────────────┼─────────────────────────┤");
        System.out.println("│ 最短路径     │ BFS(无权) / Dijkstra(加权)│");
        System.out.println("│ 社交推荐     │ BFS (N度人脉)             │");
        System.out.println("│ 构建依赖     │ 拓扑排序                   │");
        System.out.println("│ 死锁检测     │ 有向图环检测               │");
        System.out.println("│ 网络连通性   │ DFS / 并查集               │");
        System.out.println("│ 最小生成树   │ Prim / Kruskal             │");
        System.out.println("└─────────────┴─────────────────────────┘");
    }

    /** 构建示例无向图 */
    static void buildSampleGraph(AdjacencyListGraph g) {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
    }

    /** 构建示例邻接矩阵 */
    static void buildSampleMatrix(AdjacencyMatrixGraph g) {
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
    }

    // ============================================================
    // 邻接表图 (最常用)
    // ============================================================
    static class AdjacencyListGraph {
        private Map<Integer, List<Integer>> adj;
        private boolean directed;

        public AdjacencyListGraph() { this(false); }

        public AdjacencyListGraph(boolean directed) {
            this.adj = new HashMap<>();
            this.directed = directed;
        }

        public void addEdge(int u, int v) {
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            if (!directed) {
                adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            } else {
                adj.putIfAbsent(v, new ArrayList<>()); // 确保 dest 节点存在
            }
        }

        public void print() {
            for (int node : new TreeSet<>(adj.keySet())) {
                System.out.println("  " + node + " → " + adj.get(node));
            }
        }

        // ---------- DFS ----------
        public List<Integer> dfs(int start) {
            List<Integer> res = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfsHelper(start, visited, res);
            return res;
        }

        private void dfsHelper(int node, Set<Integer> visited, List<Integer> res) {
            if (!visited.add(node)) return;
            res.add(node);
            for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                dfsHelper(neighbor, visited, res);
            }
        }

        /** 迭代 DFS (显式栈) */
        public List<Integer> dfsIterative(int start) {
            List<Integer> res = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited.add(node)) continue;
                res.add(node);
                // 逆序入栈保证与递归顺序一致
                List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int nb = neighbors.get(i);
                    if (!visited.contains(nb)) stack.push(nb);
                }
            }
            return res;
        }

        // ---------- BFS ----------
        public List<Integer> bfs(int start) {
            List<Integer> res = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            visited.add(start);
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                res.add(node);
                for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
            return res;
        }

        /** BFS 最短路径 (无权图) */
        public List<Integer> shortestPath(int start, int end) {
            Map<Integer, Integer> parent = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            visited.add(start);
            queue.offer(start);
            parent.put(start, -1);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (node == end) return reconstructPath(parent, start, end);
                for (int nb : adj.getOrDefault(node, Collections.emptyList())) {
                    if (visited.add(nb)) {
                        parent.put(nb, node);
                        queue.offer(nb);
                    }
                }
            }
            return Collections.emptyList();  // 不可达
        }

        private List<Integer> reconstructPath(Map<Integer, Integer> parent, int start, int end) {
            List<Integer> path = new ArrayList<>();
            for (int at = end; at != -1; at = parent.get(at)) {
                path.add(at);
            }
            Collections.reverse(path);
            return path;
        }

        // ---------- 拓扑排序 (Kahn算法) ----------
        public List<Integer> topologicalSort() {
            Map<Integer, Integer> indegree = new HashMap<>();
            for (int node : adj.keySet()) indegree.putIfAbsent(node, 0);
            for (List<Integer> neighbors : adj.values()) {
                for (int nb : neighbors) {
                    indegree.merge(nb, 1, Integer::sum);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (Map.Entry<Integer, Integer> e : indegree.entrySet()) {
                if (e.getValue() == 0) queue.offer(e.getKey());
            }

            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                res.add(node);
                for (int nb : adj.getOrDefault(node, Collections.emptyList())) {
                    indegree.merge(nb, -1, Integer::sum);
                    if (indegree.get(nb) == 0) queue.offer(nb);
                }
            }

            if (res.size() != adj.size()) {
                System.out.println("  警告: 图中有环, 无法完成拓扑排序");
            }
            return res;
        }

        // ---------- 有向图环检测 ----------
        public boolean hasCycle() {
            Set<Integer> visiting = new HashSet<>();  // 正在访问中
            Set<Integer> visited = new HashSet<>();   // 已完全访问
            for (int node : adj.keySet()) {
                if (hasCycleDFS(node, visiting, visited)) return true;
            }
            return false;
        }

        private boolean hasCycleDFS(int node, Set<Integer> visiting, Set<Integer> visited) {
            if (visiting.contains(node)) return true;   // 遇到回边 = 有环
            if (visited.contains(node)) return false;
            visiting.add(node);
            for (int nb : adj.getOrDefault(node, Collections.emptyList())) {
                if (hasCycleDFS(nb, visiting, visited)) return true;
            }
            visiting.remove(node);
            visited.add(node);
            return false;
        }

        // ---------- 无向图环检测 ----------
        public boolean hasCycleUndirected() {
            Set<Integer> visited = new HashSet<>();
            for (int node : adj.keySet()) {
                if (!visited.contains(node)) {
                    if (hasCycleUndirectedDFS(node, -1, visited)) return true;
                }
            }
            return false;
        }

        private boolean hasCycleUndirectedDFS(int node, int parent, Set<Integer> visited) {
            visited.add(node);
            for (int nb : adj.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(nb)) {
                    if (hasCycleUndirectedDFS(nb, node, visited)) return true;
                } else if (nb != parent) {
                    return true;  // 访问过且不是父节点 = 有环
                }
            }
            return false;
        }

        // ---------- 连通分量计数 ----------
        public int countConnectedComponents() {
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            for (int node : adj.keySet()) {
                if (!visited.contains(node)) {
                    count++;
                    dfsHelper(node, visited, new ArrayList<>());
                }
            }
            return count;
        }
    }

    // ============================================================
    // 邻接矩阵图
    // ============================================================
    static class AdjacencyMatrixGraph {
        private int[][] matrix;
        private int vertices;

        public AdjacencyMatrixGraph(int vertices) {
            this.vertices = vertices;
            this.matrix = new int[vertices][vertices];
        }

        public void addEdge(int u, int v) {
            matrix[u][v] = 1;
            matrix[v][u] = 1;  // 无向图
        }

        public void print() {
            System.out.print("    ");
            for (int i = 0; i < vertices; i++) System.out.print(i + " ");
            System.out.println();
            for (int i = 0; i < vertices; i++) {
                System.out.print("  " + i + " ");
                for (int j = 0; j < vertices; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("  优点: O(1)判断是否相邻  缺点: O(V²)空间");
        }
    }

    // ============================================================
    // 加权图 (用于 Dijkstra)
    // ============================================================
    static class WeightedGraph {
        private Map<Integer, List<Edge>> adj = new HashMap<>();

        static class Edge {
            int to, weight;
            Edge(int to, int weight) { this.to = to; this.weight = weight; }
        }

        public void addEdge(int u, int v, int w) {
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, w));
        }

        public void print() {
            for (int node : new TreeSet<>(adj.keySet())) {
                List<String> edges = new ArrayList<>();
                for (Edge e : adj.get(node)) {
                    edges.add(e.to + "(" + e.weight + ")");
                }
                System.out.println("  " + node + " → " + edges);
            }
        }

        /** Dijkstra 算法 */
        public int[] dijkstra(int start) {
            int n = adj.size();
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            // 小顶堆: [节点, 距离]
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{start, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int node = cur[0], d = cur[1];
                if (d > dist[node]) continue;  // 过期数据, 跳过

                for (Edge e : adj.getOrDefault(node, Collections.emptyList())) {
                    int newDist = d + e.weight;
                    if (newDist < dist[e.to]) {
                        dist[e.to] = newDist;
                        pq.offer(new int[]{e.to, newDist});
                    }
                }
            }
            return dist;
        }
    }
}
