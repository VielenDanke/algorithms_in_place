package leetcode.array.medium.java_solutions;

public class Search2DMatrix_74 {

    private static class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int N = matrix.length, M = matrix[0].length;

            int row = 0, col = M - 1;

            while (row < N && col >= 0) {
                int current = matrix[row][col];

                if (current < target) {
                    row++;
                } else if (current > target) {
                    col--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
