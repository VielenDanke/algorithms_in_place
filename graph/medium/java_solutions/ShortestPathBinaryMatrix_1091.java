package graph.medium.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix_1091 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int rangeRow = 0;
    private int rangeCol = 0;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        rangeRow = grid.length;
        rangeCol = grid[0].length;
        int minPath = 1 << 30;

        Queue<int[]> points = new LinkedList<>();

        points.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!points.isEmpty()) {
            int[] currentPoint = points.poll();

            if (currentPoint[0] == rangeRow - 1 && currentPoint[1] == rangeCol - 1 && minPath > currentPoint[2]) {
                minPath = currentPoint[2];
                continue;
            }
            for (int[] direction : DIR) {
                int nextRow = currentPoint[0] + direction[0];
                int nextCol = currentPoint[1] + direction[1];

                if (!checkIfPointInRange(nextRow, nextCol) || grid[nextRow][nextCol] == 1) {
                    continue;
                }
                grid[nextRow][nextCol] = 1;
                points.add(new int[]{nextRow, nextCol, currentPoint[2] + 1});
            }
        }
        return minPath == 1 << 30 ? -1 : minPath;
    }

    private boolean checkIfPointInRange(int row, int col) {
        return row >= 0 && row < rangeRow && col >= 0 && col < rangeCol;
    }

}
