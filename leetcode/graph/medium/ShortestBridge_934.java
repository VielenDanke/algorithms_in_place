package leetcode.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {

    static class Solution {

        private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private int n;

        public int shortestBridge(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            this.n = grid.length;
            boolean[][] visited = new boolean[n][n];

            islandFound:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        collectIsland(queue, visited, grid, i, j);
                        break islandFound;
                    }
                }
            }
            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] current = queue.poll();
                    for (int[] dir : DIRECTIONS) {
                        int i = current[0] + dir[0];
                        int j = current[1] + dir[1];

                        if (i >= 0 && j >= 0 && i < n && j < n && !visited[i][j]) {
                            if (grid[i][j] == 1) {
                                return step;
                            }
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
                step++;
            }
            return step;
        }

        private void collectIsland(Queue<int[]> queue, boolean[][] visited, int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] == 0) {
                return;
            }
            visited[i][j] = true;
            queue.offer(new int[]{i, j});
            for (int[] dir : DIRECTIONS) {
                collectIsland(queue, visited, grid, i + dir[0], j + dir[1]);
            }
        }
    }
}
