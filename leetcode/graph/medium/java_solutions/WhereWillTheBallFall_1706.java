package leetcode.graph.medium.java_solutions;

public class WhereWillTheBallFall_1706 {

    private static class Solution {
        private int rowLength;
        private int columnLength;

        public int[] findBall(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return new int[]{};
            }
            rowLength = grid.length;
            columnLength = grid[0].length;

            int[] result = new int[columnLength];

            for (int i = 0; i < columnLength; i++) {
                result[i] = dropTheBall(grid, 0, i);
            }
            return result;
        }

        private int dropTheBall(int[][] grid, int row, int column) {
            if (row == rowLength) {
                return column;
            }
            if (isBallStuck(grid, row, column)) {
                return -1;
            }
            if (grid[row][column] == 1) {
                return dropTheBall(grid, row + 1, column + 1);
            } else {
                return dropTheBall(grid, row + 1, column - 1);
            }
        }

        private boolean isBallStuck(int[][] grid, int row, int column) {
            int direction = grid[row][column];

            if (direction == 1 && column == columnLength - 1) {
                return true;
            }
            if (direction == 1 && grid[row][column + 1] == -1) {
                return true;
            }
            if (direction == -1 && column == 0) {
                return true;
            }
            return direction == -1 && grid[row][column - 1] == 1;
        }
    }
}
