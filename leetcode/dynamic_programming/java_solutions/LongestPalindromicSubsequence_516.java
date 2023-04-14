package leetcode.dynamic_programming.java_solutions;

public class LongestPalindromicSubsequence_516 {

    static class Solution {
        private Integer[][] cache;

        public int longestPalindromeSubseq(String s) {
            this.cache = new Integer[s.length()][s.length()];
            return dp(s, 0, s.length() - 1);
        }

        private int dp(String s, int i, int j) {
            if (i > j) return 0;
            if (i == j) return 1;
            if (cache[i][j] != null) return cache[i][j];
            if (s.charAt(i) == s.charAt(j)) return cache[i][j] = dp(s, i + 1, j - 1) + 2;
            return cache[i][j] = Math.max(dp(s, i + 1, j), dp(s, i, j - 1));
        }
    }
}
