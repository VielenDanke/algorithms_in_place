package leetcode.dynamic_programming.java_solutions;

public class MinimumAsciiDeleteSumForTwoStrings_712 {

    static class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            }
            for (int i = 1; i <= m; i++) {
                dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }
                }
            }
            return dp[n][m];
        }
    }

    static class SolutionMemo {

        private Integer[][] cache;

        public int minimumDeleteSum(String s1, String s2) {
            this.cache = new Integer[s1.length()][s2.length()];
            return dfs(s1, s2, 0, 0);
        }

        private int remains(String s, int i) {
            int sum = 0;
            for (int j = i; j < s.length(); j++) {
                sum += s.charAt(j);
            }
            return sum;
        }

        private int dfs(String s1, String s2, int left, int right) {
            if (left >= s1.length() && right >= s2.length()) return 0;
            if (left >= s1.length()) return remains(s2, right);
            if (right >= s2.length()) return remains(s1, left);
            if (cache[left][right] != null) return cache[left][right];
            if (s1.charAt(left) == s2.charAt(right)) {
                return cache[left][right] = dfs(s1, s2, left + 1, right + 1);
            }
            return cache[left][right] = Math.min(s1.charAt(left) + dfs(s1, s2, left + 1, right), s2.charAt(right) + dfs(s1, s2, left, right + 1));
        }
    }
}
