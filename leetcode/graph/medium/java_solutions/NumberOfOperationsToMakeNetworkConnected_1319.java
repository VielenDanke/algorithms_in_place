package leetcode.graph.medium.java_solutions;

public class NumberOfOperationsToMakeNetworkConnected_1319 {

    static class Solution {
        private static class UnionFind {
            private final int[] id;
            private int numOfComponents;

            private UnionFind(int n) {
                id = new int[n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                }
                numOfComponents = n;
            }

            private boolean isConnected(int i, int j) {
                return find(i) == find(j);
            }

            private void union(int i, int j) {
                id[find(i)] = find(j);
                numOfComponents--;
            }

            private int find(int i) {
                while (i != id[i]) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
        }

        public int makeConnected(int n, int[][] connections) {
            // use union find
            // do union operations on computers
            // if computers already connected - add to free possible connections
            // if numOfComponnets - possibleConnections <= 1 - it is possible
            var uf = new UnionFind(n);
            var freeConnections = 0;

            for (int[] conn : connections) {
                if (uf.isConnected(conn[0], conn[1])) {
                    freeConnections++;
                } else {
                    uf.union(conn[0], conn[1]);
                }
            }
            return uf.numOfComponents - freeConnections <= 1 ? uf.numOfComponents - 1 : -1;
        }
    }
}
