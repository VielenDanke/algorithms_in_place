package leetcode.graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {

    private static class SolutionBruteForce {
        private static final int[][] DIRECTION = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        private int rowLength;
        private int colLength;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        conditions:
        traverse from current row and col to left, right, top, down and check that next value is equal or less than prev value
        if we reach atlantic and pacific ocean - add to final result

        constraints:
        heights != null
        */
            List<List<Integer>> result = new ArrayList<>();

            if (heights == null) return result;

            rowLength = heights.length;
            colLength = heights[0].length;

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (isOceansConnected(heights, i, j, true, new boolean[rowLength][colLength]) && isOceansConnected(heights, i, j, false, new boolean[rowLength][colLength])) {
                        List<Integer> coordinates = new ArrayList<>();
                        coordinates.add(i);
                        coordinates.add(j);
                        result.add(coordinates);
                    }
                }
            }
            return result;
        }

        private boolean isOceansConnected(int[][] heights, int row, int col, boolean isPacific, boolean[][] visited) {
            if (isPacific && (row == 0 || col == 0)) {
                return true;
            } else if (!isPacific && (row == rowLength - 1 || col == colLength - 1)) {
                return true;
            }
            for (int[] dir : DIRECTION) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (isBoarderCrossed(nextRow, nextCol) || heights[nextRow][nextCol] > heights[row][col] || visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                if (isOceansConnected(heights, nextRow, nextCol, isPacific, visited)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isBoarderCrossed(int row, int col) {
            return row < 0 || col < 0 || row >= rowLength || col >= colLength;
        }
    }
}