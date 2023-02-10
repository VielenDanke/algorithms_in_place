package leetcode.array.medium.java_solutions;

import java.util.*;

public class AsFarFromLandAsPossible_1162 {

    static class Solution {

        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int maxDistance(int[][] grid) {
            if (grid == null) return -1;

            int n = grid.length;

            if (n == 0) return -1;

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            int dist = -1;
            while (!queue.isEmpty()) {
                int currentSize = queue.size();

                for (int i = 0; i < currentSize; i++) {
                    int[] current = queue.poll();

                    for (int[] dir : DIRECTIONS) {
                        int nextRow = current[0] + dir[0];
                        int nextCol = current[1] + dir[1];

                        if (areBoardersValid(nextRow, nextCol, n) && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                            visited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
                dist++;
            }
            return dist <= 0 ? -1 : dist;
        }

        private boolean areBoardersValid(int row, int col, int n) {
            return row >= 0 && col >= 0 && row < n && col < n;
        }
    }

    static class SolutionBruteForce {

        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private boolean[][] visited;
        private int n;
        private int m;

        public int maxDistance(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            visited = new boolean[n][m];

            int max = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 1) {
                        Integer temp = traverse(grid, i, j, i, j);
                        if (temp != null) {
                            max = Math.max(max, temp);
                        }
                    }
                }
            }
            return max;
        }

        private Integer traverse(int[][] grid, int row, int col, int newRow, int newCol) {
            if (visited[newRow][newCol]) {
                return null;
            }
            if (grid[newRow][newCol] == 1) {
                return Math.abs(newRow - row) + Math.abs(newCol - col);
            }
            visited[newRow][newCol] = true;

            Integer min = null;

            for (int[] dir : DIRECTIONS) {
                int nextRow = newRow + dir[0];
                int nextCol = newCol + dir[1];
                if (areBoardersValid(nextRow, nextCol)) {
                    Integer temp = traverse(grid, row, col, nextRow, nextCol);
                    if (temp != null) {
                        min = min == null ? temp : Math.min(min, temp);
                    }
                }
            }
            visited[newRow][newCol] = false;
            return min;
        }

        private boolean areBoardersValid(int row, int col) {
            return row >= 0 && col >= 0 && row < n && col < m;
        }
    }
}
