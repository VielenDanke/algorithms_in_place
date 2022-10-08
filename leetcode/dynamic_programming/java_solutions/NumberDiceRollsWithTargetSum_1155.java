package leetcode.dynamic_programming.java_solutions;

public class NumberDiceRollsWithTargetSum_1155 {

    private static class SolutionDP {

        /*
        Idea as for memoization.
        Two important points here:
        1. To avoid third loop - pre-calculate and see if i * k
           (level * k >= currentTarget (j) means we can reach through all levels our target)
        2. If level * k >= currentTarget (j) - go through loop and calculate current DP[i][j] using pre-calculated
           DP[i-1][j - 1] % MOD
         */

        public int numRollsToTarget(int n, int k, int target) {
            int MOD = 1_000_000_007;

            int[][] dp = new int[n + 1][target + 1];

            dp[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j <= i * k) {
                        for (int f = 1; f <= k && f <= j; f++) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - f]) % MOD;
                        }
                    }
                }
            }
            return dp[n][target];
        }
    }

    private static class SolutionMemo {

        /*
        Idea:
        1. Each time moving deeper by one level and decrease i (range 1..k+1) from target
        2. Do it until we would reach the condition when n == 0 && target == 0 then return 1
           otherwise return 0 if n == 0 || target == 0 (means we reached target too early or cannot reach at all)
        3. MOD to decrease final value
        4. Cache - n and target of the current level Integer[n][target] = sum %= MOD
         */

        private static final int MOD = 1000000000 + 7;
        private Integer[][] cache;

        public int numRollsToTarget(int n, int k, int target) {
            this.cache = new Integer[n + 1][target + 1];
            return memo(n, k, target);
        }

        private int memo(int n, int k, int target) {
            if (n == 0 && target == 0) return 1;
            if (n == 0 || target == 0) return 0;
            if (cache[n][target] != null) return cache[n][target];
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                if (target - i < 0) {
                    break;
                }
                sum += memo(n - 1, k, target - i);
                sum %= MOD;
            }
            cache[n][target] = sum;
            return sum;
        }
    }
}
