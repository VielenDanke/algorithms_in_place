package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    static class Solution {
        private int n;
        private int m;

        public List<Integer> spiralOrder(int[][] matrix) {
            this.n = matrix.length;
            this.m = matrix[0].length;

            List<Integer> list = new ArrayList<>();

            traverse(list, matrix, 0);

            return list;
        }

        private void traverse(List<Integer> list, int[][] matrix, int diff) {
            if (list.size() >= n * m) return;
            for (int i = diff; i < m - diff; i++) {
                list.add(matrix[diff][i]);
                if (list.size() >= n * m) return;
            }
            for (int i = diff + 1; i < n - diff; i++) {
                list.add(matrix[i][m - 1 - diff]);
                if (list.size() >= n * m) return;
            }
            for (int i = m - 2 - diff; i >= diff; i--) {
                list.add(matrix[n - diff - 1][i]);
                if (list.size() >= n * m) return;
            }
            for (int i = n - 2 - diff; i >= diff + 1; i--) {
                list.add(matrix[i][diff]);
                if (list.size() >= n * m) return;
            }
            traverse(list, matrix, diff + 1);
        }
    }

    static class SolutionFirst {
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
                result.add(matrix[i][endColumn - 1]);
                if (result.size() == resultLength) {
                    return;
                }
            }
            for (int i = endColumn - 2; i >= startColumn; i--) {
                result.add(matrix[endRow - 1][i]);
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
}
