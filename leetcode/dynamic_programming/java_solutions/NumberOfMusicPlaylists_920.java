package leetcode.dynamic_programming.java_solutions;

public class NumberOfMusicPlaylists_920 {

    static class Solution {
        private static final int MOD = 1_000_000_007;

        private Long[][] dp;

        public int numMusicPlaylists(int n, int goal, int k) {
            this.dp = new Long[goal + 1][n + 1];
            return (int) (numberOfPlaylists(goal, n, k, n));
        }

        private long numberOfPlaylists(int i, int j, int k, int n) {
            if (i == 0 && j == 0) {
                return 1;
            }
            if (i == 0 || j == 0) {
                return 0;
            }
            if (dp[i][j] != null) {
                return dp[i][j];
            }
            dp[i][j] = (numberOfPlaylists(i - 1, j - 1, k, n) * (n - j + 1)) % MOD;
            if (j > k) {
                dp[i][j] += (numberOfPlaylists(i - 1, j, k, n) * (j - k)) % MOD;
                dp[i][j] %= MOD;
            }
            return dp[i][j];
        }
    }
}
