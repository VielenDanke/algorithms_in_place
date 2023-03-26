package leetcode.graph.easy.java_solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class FindIfPathExistsInGraph_1971 {

    static class SolutionUnionFind {
        private int[] id;

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            id = new int[n];

            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            for (int[] edge : edges) {
                union(edge[0], edge[1]);
            }
            return find(source) == find(destination);
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

    static class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            Map<Integer, List<Integer>> graph = buildBidirectionalGraph(edges);
            return dfs(graph, source, destination, new HashSet<>());
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int position, int endDestination, Set<Integer> visited) {
            if (position == endDestination) {
                return true;
            }
            if (visited.contains(position)) {
                return false;
            }
            List<Integer> allDest = graph.get(position);

            visited.add(position);

            for (Integer dest : allDest) {
                if (dfs(graph, dest, endDestination, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
