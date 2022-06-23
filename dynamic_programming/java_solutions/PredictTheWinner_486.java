package dynamic_programming.java_solutions;

public class PredictTheWinner_486 {

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
