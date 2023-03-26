package leetcode.graph.medium.java_solutions;

import java.util.ArrayList;

public class CountUnreachablePairsOfNodesUndirectedGraph_2316 {

    static class Solution {

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
