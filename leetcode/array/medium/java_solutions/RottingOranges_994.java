package leetcode.array.medium.java_solutions;

import java.util.ArrayDeque;

public class RottingOranges_994 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    @SuppressWarnings({"all"})
    public int orangesRotting(int[][] grid) {
        var rowLength = grid.length;
        var columnLength = grid[0].length;
        var goodOranges = 0;
        var minutes = 0;

        var queue = new ArrayDeque<int[]>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                var orange = grid[i][j];
                if (orange == 2) {
                    queue.add(new int[]{i, j});
                } else if (orange == 1) {
                    goodOranges++;
                }
            }
        }
        while (!queue.isEmpty() && goodOranges > 0) {
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                var current = queue.poll();
                var currentRow = current[0];
                var currentColumn = current[1];

                for (int[] currentDir : DIR) {
                    var nextRow = currentRow + currentDir[0];
                    var nextColumn = currentColumn + currentDir[1];

                    if (nextRow < 0 || nextColumn < 0 || nextRow >= rowLength || nextColumn >= columnLength || grid[nextRow][nextColumn] != 1) {
                        continue;
                    }
                    goodOranges--;
                    grid[nextRow][nextColumn] = 2;
                    queue.offer(new int[]{nextRow, nextColumn});
                }
            }
            minutes++;
        }
        if (goodOranges != 0) {
            return -1;
        }
        return minutes;
    }
}
