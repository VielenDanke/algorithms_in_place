package dynamic_programming.java_solutions;

import java.util.*;

public class UniquePath2_63 {

    // DP

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    // --------------------------------------------------------------------------------------------------
    // With cache

    private Map<String, Integer> cache;

    public int uniquePathsWithObstaclesWithCache(int[][] obstacleGrid) {
        int colLength = obstacleGrid[0].length;
        int rowLength = obstacleGrid.length;
        if (obstacleGrid[rowLength - 1][colLength - 1] == 1) {
            return 0;
        }
        cache = new HashMap<>();
        return dfs(obstacleGrid, 0, 0, rowLength, colLength);
    }

    private int dfs(int[][] obstacleGrid, int row, int col, int rowLength, int colLength) {
        if (row >= rowLength || col >= colLength) {
            return 0;
        }
        String key = String.format("%d,%d", row, col);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (obstacleGrid[row][col] == 1) {
            cache.put(key, 0);
            return 0;
        }
        if (row == rowLength - 1 && col == colLength - 1) {
            return 1;
        }
        int left = dfs(obstacleGrid, row + 1, col, rowLength, colLength);
        int right = dfs(obstacleGrid, row, col + 1, rowLength, colLength);
        cache.put(key, left + right);
        return left + right;
    }


    // ---------------------------------------------------------------------------------------------------
    // Backtracking
    // Time Limit Exceeded

    private int rowLength;
    private int colLength;
    private boolean[][] visited;
    private int pathCounter;

    public int uniquePathsWithObstaclesTimeLimit(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        pathCounter = 0;
        rowLength = obstacleGrid.length;
        colLength = obstacleGrid[0].length;
        visited = new boolean[rowLength][colLength];
        step(obstacleGrid, 0, 0);
        return pathCounter;
    }

    private void step(int[][] obstacleGrid, int row, int col) {
        if (row >= rowLength || col >= colLength) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (obstacleGrid[row][col] == 1) {
            return;
        }
        if (row == rowLength - 1 && col == colLength - 1) {
            pathCounter++;
            return;
        }
        visited[row][col] = true;
        step(obstacleGrid, row + 1, col);
        step(obstacleGrid, row, col + 1);
        visited[row][col] = false;
    }
}
