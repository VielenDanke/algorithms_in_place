package leetcode.binary_search.medium;

public class Search2DMatrix_74 {

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length;
            int i = n - 1, j = 0;

            while (i >= 0 && j < m) {
                int current = matrix[i][j];
                if (current < target) {
                    j++;
                } else if (current > target) {
                    i--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
