package leetcode.dynamic_programming.java_solutions;

public class UniquePath_62 {

    /*
    Pattern: sum of next position is left + up = current
    Formula: dp[row - 1][col] + dp[row][col - 1]
    If i == 0 or j == 0 means we are at the start - place 1
    Below examples of iteration by rows:
    1) Initial
    0 0 0 0
    0 0 0 0
    0 0 0 0

    2) First iteration
    1 1 1 1
    0 0 0 0
    0 0 0 0

    3) Second iteration
    1 1 1 1
    1 2 3 4
    1 3 6 10
     */

    public int uniquePathsDP(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    // --------------------------------------------------------------------------

    private int[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        return stepInto(m - 1, n - 1);
    }

    private int stepInto(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        int currentPosition = cache[row][col];
        if (currentPosition != 0) {
            return cache[row][col];
        }
        int paths = stepInto(row - 1, col) + stepInto(row, col - 1);
        cache[row][col] = paths;
        return paths;
    }
}
