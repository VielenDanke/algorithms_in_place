package leetcode.dynamic_programming.java_solutions;

public class DominoAndTrominoTiling_790 {

    static class Solution {

        private static final int MOD = (int) 1e9 + 7;
        private Long[][] dp;

        public int numTilings(int n) {
            // 2 x n square
            /*
                 n
               _____
            2 |     |
              |_____|

            length for domino - 2 and 1
            */
            dp = new Long[1001][2];
            return (int) countDominoes(0, n, false);
        }

        private long countDominoes(int sum, int n, boolean isGapExists) {
            if (sum > n) {
                return 0;
            }
            if (sum == n) {
                return isGapExists ? 0 : 1;
            }
            if (dp[sum][isGapExists ? 1 : 0] != null) return dp[sum][isGapExists ? 1 : 0];
            if (isGapExists) {
                return dp[sum][isGapExists ? 1 : 0] = (countDominoes(sum + 1, n, false) + countDominoes(sum + 1, n, true)) % MOD;
            }
            return dp[sum][isGapExists ? 1 : 0] = (countDominoes(sum + 1, n, false) + countDominoes(sum + 2, n, false) + 2 * countDominoes(sum + 2, n, true)) % MOD;
        }
    }
}
