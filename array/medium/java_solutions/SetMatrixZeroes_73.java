package array.medium.java_solutions;

import java.util.Stack;

public class SetMatrixZeroes_73 {

    static class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void setZeroes(int[][] matrix) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    stack.add(new Pair(i, j));
                }
            }
        }
        while (stack.size() > 0) {
            Pair pair = stack.pop();

            int row = 0;
            int column = pair.column;

            while (row < matrix.length) {
                matrix[row][column] = 0;
                row++;
            }
            row = pair.row;
            column = 0;

            while (column < matrix[0].length) {
                matrix[row][column] = 0;
                column++;
            }
        }
    }

    // ---------------------------------------------------------------------

    public void setZeroesWithoutStack(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1 << 18;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 << 18) {
                    int row = 0;
                    int column = j;

                    while (row < matrix.length) {
                        if (matrix[row][column] != 1 << 18) {
                            matrix[row][column] = 0;
                        }
                        row++;
                    }
                    row = i;
                    column = 0;

                    while (column < matrix[0].length) {
                        if (matrix[row][column] != 1 << 18) {
                            matrix[row][column] = 0;
                        }
                        column++;
                    }
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
