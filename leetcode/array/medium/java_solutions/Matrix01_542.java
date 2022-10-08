package leetcode.array.medium.java_solutions;

import java.util.ArrayDeque;

public class Matrix01_542 {

    private static final int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        var rowLength = mat.length;
        var colLength = mat[0].length;
        var queue = new ArrayDeque<int[]>();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            var row = pair[0];
            var column = pair[1];

            for (int[] direction : DIR) {
                var nextRow = row + direction[0];
                var nextColumn = column + direction[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= rowLength || nextColumn >= colLength || mat[nextRow][nextColumn] != -1) {
                    continue;
                }
                mat[nextRow][nextColumn] = mat[row][column] + 1;
                queue.offer(new int[]{nextRow, nextColumn});
            }
        }
        return mat;
    }
}
