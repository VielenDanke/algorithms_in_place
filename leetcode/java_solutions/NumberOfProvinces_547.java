package leetcode.java_solutions;

public class NumberOfProvinces_547 {

    /*
    Link to explanation - https://leetcode.com/problems/number-of-provinces/discuss/2024592/Java-or-DFS-or-Union-Find
     */

    public int findCircleNumDFS(int[][] provinces) {
        int[] visited = new int[provinces.length];
        int count = 0;
        for (int i = 0; i < provinces.length; i++) {
            if (visited[i] == 0) {
                dfs(provinces, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] provinces, int[] visited, int i) {
        for (int j = 0; j < provinces.length; j++) {
            if (provinces[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(provinces, visited, j);
            }
        }
    }

    // ----------------------------------------------------------------------

    private static class UnionFind {

        private final int[] id;
        private int numOfComponents;

        private UnionFind(int size) {
            id = new int[size];
            numOfComponents = size;

            for (int i = 0; i < size; i++) id[i] = i;
        }

        private int getNumOfComponents() {
            return numOfComponents;
        }

        private boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        private void union(int p, int q) {
            id[find(p)] = find(q);
            numOfComponents--;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] != 0 && !unionFind.connected(i, j)) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getNumOfComponents();
    }
}
