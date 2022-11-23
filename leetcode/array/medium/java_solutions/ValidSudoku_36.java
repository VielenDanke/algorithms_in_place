package leetcode.array.medium.java_solutions;

public class ValidSudoku_36 {

    static class Solution {

        private static final int SUDOKU_SIDE = 9;

        public boolean isValidSudoku(char[][] board) {
            return areRowsValid(board) && areColumnsValid(board) && areSquaresValid(board);
        }

        public boolean areRowsValid(char[][] board) {
            for (int i = 0; i < SUDOKU_SIDE; i++) {
                int[] numbers = new int[SUDOKU_SIDE + 1];
                for (int j = 0; j < SUDOKU_SIDE; j++) {
                    if (board[i][j] != '.') {
                        numbers[board[i][j] - '0']++;
                        if (numbers[board[i][j] - '0'] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean areColumnsValid(char[][] board) {
            for (int i = 0; i < SUDOKU_SIDE; i++) {
                int[] numbers = new int[SUDOKU_SIDE + 1];
                for (int j = 0; j < SUDOKU_SIDE; j++) {
                    if (board[j][i] != '.') {
                        numbers[board[j][i] - '0']++;
                        if (numbers[board[j][i] - '0'] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean areSquaresValid(char[][] board) {
            for (int i = 0; i < SUDOKU_SIDE; i += 3) {
                for (int j = 0; j < SUDOKU_SIDE; j += 3) {
                    if (!isSquareValid(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isSquareValid(char[][] board, int row, int col) {
            int[] numbers = new int[SUDOKU_SIDE + 1];
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] != '.') {
                        numbers[board[i][j] - '0']++;
                        if (numbers[board[i][j] - '0'] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
