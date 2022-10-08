package leetcode.backtracking_recursion.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class MaximumRowsCoveredByColumns_2397 {

    static class Solution {
        private int max;
        private int m;

        public int maximumRows(int[][] matrix, int numSelect) {
            /*
            Row is covered:
            1. matrix[row][col] == 1, col in rowSet {0, 2}
            2. row doesn't contain 1
            */
            if (matrix == null || matrix.length == 0) return 0;

            m = matrix[0].length;
            max = 0;

            backtrack(matrix, new HashSet<>(), numSelect, 0);

            return max;
        }

        private void backtrack(int[][] matrix, Set<Integer> temp, int numSelect, int start) {
            if (numSelect == 0) {
                max = Math.max(max, countCoverRows(matrix, temp));
                return;
            }
            for (int i = start; i < m; i++) {
                temp.add(i);
                backtrack(matrix, temp, numSelect - 1, i + 1);
                temp.remove(i);
            }
        }

        private int countCoverRows(int[][] matrix, Set<Integer> temp) {
            int counter = 0;
            for (int[] row : matrix) {
                if (isAllCellsWithOneInSet(row, temp)) {
                    counter++;
                } else if (isNoOneRow(row)) {
                    counter++;
                }
            }
            return counter;
        }

        private boolean isAllCellsWithOneInSet(int[] array, Set<Integer> temp) {
            for (int i = 0; i < m; i++) {
                if (array[i] == 1 && !temp.contains(i)) return false;
            }
            return true;
        }

        private boolean isNoOneRow(int[] array) {
            for (int cell : array) {
                if (cell == 1) return false;
            }
            return true;
        }
    }
}
