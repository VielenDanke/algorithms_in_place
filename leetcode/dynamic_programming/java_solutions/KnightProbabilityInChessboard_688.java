package leetcode.dynamic_programming.java_solutions;

public class KnightProbabilityInChessboard_688 {

    static class Solution {

        private static final int[][] DIRECTIONS = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

        private int n;
        private double[][][] dp;

        public double knightProbability(int n, int k, int row, int col) {
            this.n = n;
            dp = new double[n][n][k + 1];
            return backtrack(k, row, col);
        }

        private double backtrack(int k, int row, int col) {
            if (isOutOfBoarder(row, col)) {
                return 0;
            }
            if (k == 0) {
                return 1;
            }
            if (dp[row][col][k] != 0) {
                return dp[row][col][k];
            }
            double rate = 0;
            for (int[] dir : DIRECTIONS) {
                rate += 0.125 * backtrack(k - 1, row + dir[0], col + dir[1]);
            }
            return dp[row][col][k] = rate;
        }

        private boolean isOutOfBoarder(int row, int col) {
            return row < 0 || col < 0 || row >= n || col >= n;
        }
    }
}
