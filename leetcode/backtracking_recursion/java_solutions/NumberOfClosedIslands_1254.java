package leetcode.backtracking_recursion.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands_1254 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static boolean isBoardersViolated(int[][] grid, int x, int y) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }

    static class SolutionBFS {

        private int[][] grid;
        private boolean[][] visited;

        public int closedIsland(int[][] grid) {
            this.grid = grid;
            this.visited = new boolean[grid.length][grid[0].length];
            int result = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0 && !visited[i][j] && isClosedIsland(i, j)) {
                        result++;
                    }
                }
            }
            return result;
        }

        private boolean isClosedIsland(int i, int j) {
            boolean isClosed = true;

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{i, j});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (isBoardersViolated(grid, x, y)) {
                        isClosed = false;
                    } else if (grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            return isClosed;
        }
    }

    static class SolutionDFS {

        private int[][] grid;
        private boolean[][] visited;

        public int closedIsland(int[][] grid) {
            this.grid = grid;
            this.visited = new boolean[grid.length][grid[0].length];
            int result = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0 && !visited[i][j] && isSurrounderByWater(i, j)) {
                        result++;
                    }
                }
            }
            return result;
        }

        private boolean isSurrounderByWater(int x, int y) {
            if (isBoardersViolated(grid, x, y)) {
                return false;
            }
            if (grid[x][y] == 1 || visited[x][y]) {
                return true;
            }
            visited[x][y] = true;
            boolean isClosed = true;

            for (int[] dir : DIRECTIONS) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (!isSurrounderByWater(r, c)) {
                    isClosed = false;
                }
            }
            return isClosed;
        }
    }
}
