package array.medium.java_solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortMatrixDiagonally_1329 {

    private static class Solution {
        private int rowLength;
        private int colLength;

        public int[][] diagonalSort(int[][] mat) {
            /*
            startRow = mat.length - 1
            startCol = 0

            Move diagonal starting point, nextStep:
            startRow - 1
            if (startRow < 0) {
                startCol + 1
            }

            Reverse
            For each step - do reverse
            */
            rowLength = mat.length;
            colLength = mat[0].length;

            int row = rowLength - 1, col = 0;

            while (col < colLength) {
                reverseDiagonal(mat, row, col);
                if (row > 0) {
                    row--;
                } else {
                    col++;
                }
            }
            return mat;
        }

        private void reverseDiagonal(int[][] mat, int startRow, int startCol) {
            Queue<Integer> temp = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
            int row = startRow, col = startCol;
            while (row < rowLength && col < colLength) {
                temp.add(mat[row][col]);
                row++;
                col++;
            }
            row = startRow;
            col = startCol;
            while (!temp.isEmpty() && row < rowLength && col < colLength) {
                mat[row][col] = temp.poll();
                row++;
                col++;
            }
        }
    }
}
