package graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

// define boarders
// if region connected to boarder - save it
// if region is not connected to boarder - erase it
// iterates over board and if we found a boarder we will dfs over it recursively
// problems:
// 1. we have to track all coordinates
// 2. check board sizes at each recursive call

public class SurroundedRegions_130 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private final int zeroBoarder = 0;
    private int rowBoarder;
    private int colBoarder;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rowBoarder = board.length;
        colBoarder = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    List<int[]> coordinates = new ArrayList<>();
                    coordinates.add(new int[]{i, j});
                    board[i][j] = 'X';
                    boolean isConnected = explore(board, i, j, coordinates);

                    if (isConnected) {
                        for (int[] coord : coordinates) {
                            board[coord[0]][coord[1]] = 'O';
                        }
                    }
                }
            }
        }
    }

    private boolean explore(char[][] board, int i, int j, List<int[]> coordinates) {
        if (i == zeroBoarder || j == zeroBoarder || i == rowBoarder || j == colBoarder) {
            return true;
        }
        for (int[] direction : DIR) {
            int nextRow = i + direction[0];
            int nextCol = j + direction[1];

            if (isOutOfRange(nextRow, nextCol) || board[nextRow][nextCol] == 'X') {
                continue;
            }
            coordinates.add(new int[]{nextRow, nextCol});
            board[nextRow][nextCol] = 'X';
            boolean isConnected = explore(board, nextRow, nextCol, coordinates);
            if (isConnected) {
                return true;
            }
        }
        return false;
    }

    // ---------------------------------------------------------------------------------------------


    public void solveBetter(char[][] board) {
        rowBoarder = board.length;
        colBoarder = board[0].length;

        for (int j = 0; j < colBoarder; j++) {
            if (board[zeroBoarder][j] == 'O') {
                explore(board, zeroBoarder, j);
            }
            if (board[rowBoarder - 1][j] == 'O') {
                explore(board, rowBoarder - 1, j);
            }
        }
        for (int i = 0; i < rowBoarder; i++) {
            if (board[i][zeroBoarder] == 'O') {
                explore(board, i, zeroBoarder);
            }
            if (board[i][colBoarder - 1] == 'O') {
                explore(board, i, colBoarder - 1);
            }
        }
        for (int i = 0; i < rowBoarder; i++) {
            for (int j = 0; j < colBoarder; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void explore(char[][] board, int row, int col) {
        board[row][col] = '*';

        for (int[] direction : DIR) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isOutOfRange(nextRow, nextCol) || board[nextRow][nextCol] == 'X' || board[nextRow][nextCol] == '*') {
                continue;
            }
            explore(board, nextRow, nextCol);
        }
    }

    // ------------------------------------------------------------------------------------------------------------

    // Helper Methods

    private boolean isOutOfRange(int row, int col) {
        return row < zeroBoarder || row >= rowBoarder || col < zeroBoarder || col >= colBoarder;
    }
}
