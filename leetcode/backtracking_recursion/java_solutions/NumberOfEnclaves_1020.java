package leetcode.backtracking_recursion.java_solutions;

public class NumberOfEnclaves_1020 {

    private static boolean areBoardersViolated(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }

    static class SolutionFasterDFS {
        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private int[][] grid;

        public int numEnclaves(int[][] grid) {
            this.grid = grid;
            int n = grid.length, m = grid[0].length;

            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 1) {
                    dfs(i, 0);
                }
                if (grid[i][m - 1] == 1) {
                    dfs(i, m - 1);
                }
            }
            for (int j = 0; j < m; j++) {
                if (grid[0][j] == 1) {
                    dfs(0, j);
                }
                if (grid[n - 1][j] == 1) {
                    dfs(n - 1, j);
                }
            }
            int result = 0;
            for (int[] row : grid) {
                for (int j = 0; j < m; j++) {
                    result += row[j];
                }
            }
            return result;
        }

        private void dfs(int i, int j) {
            if (areBoardersViolated(grid, i, j) || grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            for (int[] dir : DIRECTIONS) {
                dfs(i + dir[0], j + dir[1]);
            }
        }
    }

    static class SolutionDFS {

        private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private int[][] grid;
        private boolean[][] visited;

        public int numEnclaves(int[][] grid) {
            this.grid = grid;
            int n = grid.length, m = grid[0].length;
            this.visited = new boolean[n][m];

            int result = 0;

            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 1) {
                    dfs(i, 0);
                }
                if (grid[i][m - 1] == 1) {
                    dfs(i, m - 1);
                }
            }
            for (int j = 0; j < m; j++) {
                if (grid[0][j] == 1) {
                    dfs(0, j);
                }
                if (grid[n - 1][j] == 1) {
                    dfs(n - 1, j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        result += isSurroundedByWater(i, j);
                    }
                }
            }
            return result;
        }

        private void dfs(int i, int j) {
            if (areBoardersViolated(grid, i, j) || grid[i][j] == 0 || visited[i][j]) return;
            visited[i][j] = true;
            for (int[] dir : DIRECTIONS) {
                dfs(i + dir[0], j + dir[1]);
            }
        }

        private int isSurroundedByWater(int i, int j) {
            if (grid[i][j] == 0 || visited[i][j]) {
                return 0;
            }
            int counter = 0;

            visited[i][j] = true;

            for (int[] dir : DIRECTIONS) {
                int x = i + dir[0];
                int y = j + dir[1];
                counter += isSurroundedByWater(x, y);
            }
            return counter + 1;
        }
    }
}
