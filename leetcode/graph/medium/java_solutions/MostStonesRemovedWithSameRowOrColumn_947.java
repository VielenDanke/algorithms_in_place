package leetcode.graph.medium.java_solutions;

public class MostStonesRemovedWithSameRowOrColumn_947 {

    static class SolutionDFS {
        private int n;

        public int removeStones(int[][] stones) {
            n = stones.length;
            boolean[] visited = new boolean[n];
            int numOfIslands = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, stones, visited);
                    numOfIslands++;
                }
            }
            return n - numOfIslands;
        }

        private void dfs(int prevIdx, int[][] stones, boolean[] visited) {
            visited[prevIdx] = true;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && (stones[prevIdx][0] == stones[i][0] || stones[prevIdx][1] == stones[i][1])) {
                    dfs(i, stones, visited);
                }
            }
        }
    }

    static class Solution {
        private int[] id;
        private int numOfComponents;

        public int removeStones(int[][] stones) {
            int length = stones.length;
            id = new int[length];
            numOfComponents = length;

            for (int i = 0; i < length; i++) {
                id[i] = i;
            }

            for (int i = 0; i < length; i++) {
                int[] iStone = stones[i];
                for (int j = 0; j < length; j++) {
                    int[] jStone = stones[j];
                    if ((iStone[0] == jStone[0] || iStone[1] == jStone[1]) && !isConnected(i, j)) {
                        union(i, j);
                    }
                }
            }
            return length - numOfComponents;
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        private void union(int i, int j) {
            id[find(i)] = find(j);
            numOfComponents--;
        }
    }
}
