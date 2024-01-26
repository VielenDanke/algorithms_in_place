package leetcode.dynamic_programming.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

public class OutOfBoundaryPaths_576 {

    static class SolutionDfsMemo {
        private static final int MOD = (int) (10e8 + 7);
        private Integer[][][] cache;

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            cache = new Integer[m][n][maxMove + 1];
            return dfs(m, n, maxMove, startRow, startColumn);
        }

        private int dfs(int m, int n, int move, int row, int col) {
            if (row < 0 || col < 0 || row >= m || col >= n) return 1;
            if (move == 0) return 0;
            if (cache[row][col][move] != null) return cache[row][col][move];

            int rowMove = (dfs(m, n, move - 1, row - 1, col) + dfs(m, n, move - 1, row + 1, col)) % MOD;
            int colMove = (dfs(m, n, move - 1, row, col - 1) + dfs(m, n, move - 1, row, col + 1)) % MOD;

            return cache[row][col][move] = (rowMove + colMove) % MOD;
        }
    }

    static class SolutionBfs {
        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        private static final int MOD = (int) (10e8 + 7);

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{startRow, startColumn, maxMove});

            long result = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[2] == 0) continue;

                for (int[] dir : DIRECTIONS) {
                    int nextRow = current[0] + dir[0];
                    int nextCol = current[1] + dir[1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n) {
                        result++;
                        continue;
                    }
                    queue.offer(new int[]{nextRow, nextCol, current[2] - 1});
                }
            }
            return (int) (result % MOD);
        }
    }
}
