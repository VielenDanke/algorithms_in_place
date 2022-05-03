package array.medium.java_solutions;

public class Search2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1, column = 0;

        while (row >= 0 && column < matrix[0].length) {
            int current = matrix[row][column];

            if (current == target) {
                return true;
            } else if (current > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }
}
