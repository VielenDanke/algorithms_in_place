package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        collectRecursive(matrix, result, 0, 0, matrix.length, matrix[0].length, matrix.length * matrix[0].length);
        return result;
    }

    private void collectRecursive(int[][] matrix, List<Integer> result, int startRow, int startColumn, int endRow, int endColumn, int resultLength) {
        for (int i = startColumn; i < endColumn; i++) {
            result.add(matrix[startRow][i]);
            if (result.size() == resultLength) {
                return;
            }
        }
        for (int i = startRow + 1; i < endRow; i++) {
            result.add(matrix[i][endColumn-1]);
            if (result.size() == resultLength) {
                return;
            }
        }
        for (int i = endColumn - 2; i >= startColumn; i--) {
            result.add(matrix[endRow-1][i]);
            if (result.size() == resultLength) {
                return;
            }
        }
        for (int i = endRow - 2; i >= startRow + 1; i--) {
            result.add(matrix[i][startColumn]);
            if (result.size() == resultLength) {
                return;
            }
        }
        collectRecursive(matrix, result, startRow + 1, startColumn + 1, endRow - 1, endColumn - 1, resultLength);
    }
}
