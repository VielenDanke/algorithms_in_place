package graph.medium.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_994 {

    private static class Solution {
        private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private Queue<int[]> queue;
        private int rowLength;
        private int colLength;
        private int freshOranges;

        public int orangesRotting(int[][] grid) {
            this.rowLength = grid.length;
            this.colLength = grid[0].length;
            this.freshOranges = 0;
            this.queue = new LinkedList<>();
            int minutes = 0;

            collectOranges(grid);

            while (!queue.isEmpty() && this.freshOranges > 0) {
                int currentSize = queue.size();
                addRottenOranges(grid, currentSize);
                minutes++;
            }
            if (this.freshOranges != 0) {
                return -1;
            }
            return minutes;
        }

        private void collectOranges(int[][] grid) {
            for (int i = 0; i < this.rowLength; i++) {
                for (int j = 0; j < this.colLength; j++) {
                    int orange = grid[i][j];
                    if (orange == 1) {
                        this.freshOranges++;
                    } else if (orange == 2) {
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        private void addRottenOranges(int[][] grid, int currentSize) {
            for (int i = 0; i < currentSize; i++) {
                int[] rottenOrange = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int nextRow = rottenOrange[0] + dir[0];
                    int nextCol = rottenOrange[1] + dir[1];
                    if (isDirectionExists(nextRow, nextCol) && grid[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        this.freshOranges--;
                    }
                }
            }
        }

        private boolean isDirectionExists(int row, int col) {
            return row >= 0 && col >= 0 && row < this.rowLength && col < this.colLength;
        }
    }
}
