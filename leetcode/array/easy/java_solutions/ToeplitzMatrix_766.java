package leetcode.array.easy.java_solutions;

public class ToeplitzMatrix_766 {

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class SolutionBruteForce {
        private int n;
        private int m;

        public boolean isToeplitzMatrix(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;

            for (int i = n - 1; i >= 0; i--) {
                if (!isToeplitz(matrix, i, 0)) {
                    return false;
                }
            }
            for (int i = 0; i < m; i++) {
                if (!isToeplitz(matrix, 0, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isToeplitz(int[][] matrix, int row, int col) {
            int startValue = matrix[row][col];
            for (int i = row, j = col; i < n && j < m; i++, j++) {
                if (startValue != matrix[i][j]) {
                    return false;
                }
            }
            return true;
        }
    }
}
