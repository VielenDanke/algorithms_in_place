package leetcode.graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class CountUnreachablePairsOfNodesUndirectedGraph_2316 {

    static class SolutionDFS {

        public long countPairs(int n, int[][] edges) {
            Map<Integer, List<Integer>> bidirectionalGraph = buildBidirectionalGraph(edges);

            boolean[] visited = new boolean[n];

            var visitedNodes = 0L;
            var numUnreachablePairsOfNodes = 0L;

            for (int node = 0; node < n; node++) {
                if (!visited[node]) {
                    var nodesInGroup = dfs(node, visited, bidirectionalGraph);
                    numUnreachablePairsOfNodes += nodesInGroup * visitedNodes;
                    visitedNodes += nodesInGroup;
                }
            }
            return numUnreachablePairsOfNodes;
        }

        private long dfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
            visited[node] = true;
            var numConnectedNodes = 1L;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    numConnectedNodes += dfs(neighbor, visited, graph);
                }
            }
            return numConnectedNodes;
        }
    }

    static class SolutionUnionFind {

        private static class UnionFind {

            private final int[] id, sz;

            private UnionFind(int n) {
                id = new int[n];
                sz = new int[n];

                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    sz[i] = 1;
                }
            }

            private void union(int p, int q) {
                int px = find(p);
                int qx = find(q);
                if (px == qx) return;

                if (sz[px] < sz[qx]) {
                    sz[qx] += sz[px];
                    id[px] = qx;
                } else {
                    sz[px] += sz[qx];
                    id[qx] = px;
                }
            }

            private int find(int p) {
                while (p != id[p]) {
                    id[p] = id[id[p]];
                    p = id[p];
                }
                return p;
            }
        }

        public long countPairs(int n, int[][] edges) {
            var uf = new UnionFind(n);

            for (int[] edge : edges) uf.union(edge[0], edge[1]);

            var list = new ArrayList<Long>();

            for (int i = 0; i < n; i ++) {
                if (uf.find(i) == i) {
                    list.add((long) uf.sz[i]);
                }
            }
            var connectedPairs = 0L;
            var total = n * (n - 1L) / 2;

            for (long root : list) {
                connectedPairs += root * (root - 1) / 2;
            }
            return total - connectedPairs;
        }
    }
}
