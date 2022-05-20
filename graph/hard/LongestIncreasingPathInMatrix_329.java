package graph.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class LongestIncreasingPathInMatrix_329 {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int rowLength;
    private int colLength;

    public int longestIncreasingPath(int[][] matrix) {
        int longest = 0;
        rowLength = matrix.length;
        colLength = matrix[0].length;
        int[][] cache = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                longest = Math.max(explore(matrix, i, j, cache), longest);
            }
        }
        return longest;
    }

    private int explore(int[][] matrix, int row, int col, int[][] cache) {
        if (cache[row][col] != 0) return cache[row][col];
        int max = 1;
        for (int[] direction : DIR) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isOutOfBoarder(nextRow, nextCol) || matrix[nextRow][nextCol] <= matrix[row][col]) {
                continue;
            }
            max = Math.max(explore(matrix, nextRow, nextCol, cache) + 1, max);
        }
        cache[row][col] = max;
        return max;
    }

    private boolean isOutOfBoarder(int row, int col) {
        return row < 0 || col < 0 || row >= rowLength || col >= colLength;
    }
}
