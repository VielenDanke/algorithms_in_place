package leetcode.dynamic_programming.java_solutions;

public class MinimumPathSum_64 {

    static class SolutionDP {
        public int minPathSum(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            for (int i = 1; i < n; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < m; j++) {
                grid[0][j] = grid[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[n - 1][m - 1];
        }
    }

    static class SolutionRecursive {
        private int rowLength;
        private int colLength;
        private Integer[][] cache;

        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            rowLength = grid.length;
            colLength = grid[0].length;
            cache = new Integer[rowLength][colLength];
            return pathWalk(grid, 0, 0);
        }

        private int pathWalk(int[][] grid, int row, int col) {
            if (row >= rowLength || col >= colLength) return 1 << 30;
            if (cache[row][col] != null) return cache[row][col];
            if (row == rowLength - 1 && col == colLength - 1) return grid[row][col];
            int min = Math.min(pathWalk(grid, row, col + 1), pathWalk(grid, row + 1, col)) + grid[row][col];
            cache[row][col] = min;
            return min;
        }
    }
}
