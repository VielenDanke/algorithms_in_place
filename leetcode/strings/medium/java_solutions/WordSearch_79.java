package leetcode.strings.medium.java_solutions;

public class WordSearch_79 {

    private int N;
    private int M;

    public boolean existOther(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        N = board.length;
        M = board[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (explore(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean explore(char[][] board, int row, int col, String word, int idx) {
        if (idx == word.length()) return true;
        if (row >= N || col >= M || row < 0 || col < 0 || board[row][col] != word.charAt(idx)) return false;
        board[row][col] = '*';
        boolean isFound = explore(board, row + 1, col, word, idx + 1) ||
                explore(board, row - 1, col, word, idx + 1) ||
                explore(board, row, col + 1, word, idx + 1) ||
                explore(board, row, col - 1, word, idx + 1);
        board[row][col] = word.charAt(idx);
        return isFound;
    }

    // -------------------------------------------------------------------------

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char REPLACE_SYMBOL = '~';

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (explore(board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean explore(char[][] board, String word, int i, int j) {
        if (word.length() == 1) {
            return word.charAt(0) == board[i][j];
        }
        if (word.charAt(0) != board[i][j]) {
            return false;
        }
        board[i][j] = REPLACE_SYMBOL;
        for (int[] direction : DIR) {
            var nextRow = i + direction[0];
            var nextColumn = j + direction[1];

            if (nextRow < 0 || nextColumn < 0 || nextRow >= board.length || nextColumn >= board[0].length || board[nextRow][nextColumn] == REPLACE_SYMBOL) {
                continue;
            }
            if (explore(board, word.substring(1), nextRow, nextColumn)) {
                return true;
            }
        }
        board[i][j] = word.charAt(0);
        return false;
    }
}
