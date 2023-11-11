package leetcode.structures.java_solutions;

import java.util.*;

public class DesignGraphWithShortestPathCalculator_2642 {

    /**
     * The steps:
     * 1. Add the edges to the graph map (edge -> all directly connected edges with the distance)
     * 2. Find the shortest path using {@linkplain <a href="https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm">Dijkstra's algorithm</a>}
     * 3. When we reach the required node - return with the shotest path
     */
    static class Graph {

        private final Map<Integer, List<int[]>> graph;

        public Graph(int n, int[][] edges) {
            this.graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
        }

        public void addEdge(int[] edge) {
            this.graph.putIfAbsent(edge[0], new ArrayList<>());
            this.graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(left -> left[1]));

            Set<Integer> visited = new HashSet<>();

            Map<Integer, Integer> result = new HashMap<>();

            queue.offer(new int[]{node1, 0});

            result.put(node1, 0);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentPos = current[0];
                int currentDis = current[1];

                if (visited.contains(currentPos)) {
                    continue;
                }
                int minResult = result.merge(currentPos, currentDis, Math::min);

                if (currentPos == minResult) return minResult;

                visited.add(currentPos);

                for (int[] nextNode : graph.getOrDefault(currentPos, List.of())) {
                    queue.offer(new int[]{nextNode[0], currentDis + nextNode[1]});
                }
            }
            return result.getOrDefault(node2, -1);
        }
    }
}
