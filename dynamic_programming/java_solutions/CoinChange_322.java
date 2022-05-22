package dynamic_programming.java_solutions;

import java.util.Arrays;

public class CoinChange_322 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }

    // ------------------------------------------------------------------------------------------

    public int coinChangeSecond(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (Math.min(temp, min));
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}
