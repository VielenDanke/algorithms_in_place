package dynamic_programming.java_solutions;

public class PredictTheWinner_486 {

    /*
    Pattern:
    1. Move from start and end
    2. If i == j - place coin at index i or j to dp[i][j]
    3. If i != j - place max(coins[i] - dp[i + 1][j], coins[j] - dp[i][j - 1])

    Example:
    Input - [1, 7, 233, 5]
    dp - [[0, 0, 0, 0],
          [0, 0, 0, 0],
          [0, 0, 0, 0],
          [0, 0, 0, 0]]

    1. dp[3] (i = 3, max of j iterations - 0) - [0, 0, 0, 5] (place 5 because it is only case when i == j)
    2. dp[2] (i = 2, max of j iterations - 1) - [0, 0, 233, 228] (place 223 because i == j, place 228 because coins[i] (233) - dp[i + 1][j] (5) = 228
    3. dp[1] (i = 1, max of j iterations - 2) - [0, 7, 226, -221] (place 7 because i == j, place 226 because coins[j] (233) - dp[i][j - 1] (7) = 226
    4. dp[0] (i = 0, max of j iterations - 3) - [1, 6, 227, 222] (place 1 because i == j, place 6 because coins[j] - dp[i][j - 1] (1) = 6 etc.
     */

    // DP

    public boolean playGame(int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N][N];

        for (int i = N; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp[i][j] = coins[i];
                } else {
                    dp[i][j] = Math.max(coins[i] - dp[i + 1][j], coins[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1] >= 0;
    }

    // --------------------------------------------------------------------------------------------
    // Memo

    private Integer[][] memo;

    public boolean predictTheWinner(int[] coins) {
        int N = coins.length;
        memo = new Integer[N][N];
        return canWin(coins, 0, N - 1) >= 0;
    }

    private int canWin(int[] coins, int left, int right) {
        if (left >= right) {
            return coins[left];
        }
        if (memo[left][right] != null) return memo[left][right];
        int firstNum = coins[left] - canWin(coins, left + 1, right);
        int secondNum = coins[right] - canWin(coins, left, right - 1);
        memo[left][right] = Math.max(firstNum, secondNum);
        return memo[left][right];
    }
}
