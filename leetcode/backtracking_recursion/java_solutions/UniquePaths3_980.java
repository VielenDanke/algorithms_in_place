package leetcode.backtracking_recursion.java_solutions;

public class UniquePaths3_980 {

    static class Solution {

        private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private int n;
        private int m;
        private int empty;

        public int uniquePathsIII(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            empty = 1;
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        x = i;
                        y = j;
                    } else if (grid[i][j] == 0) {
                        empty++;
                    }
                }
            }
            return backtrack(grid, x, y);
        }

        private int backtrack(int[][] grid, int row, int col) {
            if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] < 0) {
                return 0;
            }
            if (grid[row][col] == 2) {
                return empty == 0 ? 1 : 0;
            }
            grid[row][col] = -2;
            empty--;
            int paths = 0;
            for (int[] dir : DIRECTIONS) {
                paths += backtrack(grid, row + dir[0], col + dir[1]);
            }
            empty++;
            grid[row][col] = 0;
            return paths;
        }
    }
}
