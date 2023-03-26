package leetcode.graph.medium.java_solutions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class PossibleBipartition_886 {

    static class SolutionDFS {

        public boolean possibleBipartition(int n, int[][] dislikes) {
            Map<Integer, List<Integer>> graph = buildBidirectionalGraph(dislikes);

            int[] colors = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (colors[i] == 0 && isGroupIntersectionFound(graph, colors, i, 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isGroupIntersectionFound(Map<Integer, List<Integer>> graph, int[] colors, int current, int color) {
            colors[current] = color;

            for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                if (colors[next] == color) {
                    return true;
                }
                if (colors[next] == 0 && isGroupIntersectionFound(graph, colors, next, -color)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class SolutionUnionFind {

        private int[] id;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            id = new int[n];

            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            Map<Integer, List<Integer>> graph = buildBidirectionalGraph(dislikes);

            for (int i = 1; i <= n; i++) {
                List<Integer> neighbors = graph.get(i);

                if (neighbors == null || neighbors.isEmpty()) continue;

                int firstNeighbor = neighbors.get(0);

                for (int neighbor : neighbors) {
                    if (isConnected(i - 1, neighbor - 1)) return false;
                    union(firstNeighbor - 1, neighbor - 1);
                }
            }
            return true;
        }

        private boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        private void union(int p, int q) {
            id[find(p)] = find(q);
        }

        private int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }
    }
}
