package leetcode.graph.medium.java_solutions;

import java.util.*;

public class ShortestPathWithAlternatingColors_1129 {

    static class Solution {

        private int[][] paths;
        private Map<Integer, List<Integer>> redDirections;
        private Map<Integer, List<Integer>> blueDirections;

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            redDirections = formGraph(redEdges);
            blueDirections = formGraph(blueEdges);
            paths = new int[2][n];

            Arrays.fill(paths[0], 1, n, Integer.MAX_VALUE);
            Arrays.fill(paths[1], 1, n, Integer.MAX_VALUE);

            dfs(0, 0, 0);
            dfs(0, 1, 0);

            for (int i = 1; i < n; i++) {
                int minPath = Math.min(paths[0][i], paths[1][i]);
                paths[0][i] = minPath == Integer.MAX_VALUE ? -1 : minPath;
            }
            return paths[0];
        }

        private void dfs(int v, int color, int counter) {
            Map<Integer, List<Integer>> edges = color == 0 ? redDirections : blueDirections;
            for (int u : edges.getOrDefault(v, new ArrayList<>())) {
                if (paths[1 - color][u] > counter + 1) {
                    paths[1 - color][u] = counter + 1;
                    dfs(u, 1 - color, counter + 1);
                }
            }
        }

        private Map<Integer, List<Integer>> formGraph(int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.get(edge[0]).add(edge[1]);
            }
            return graph;
        }
    }
}
