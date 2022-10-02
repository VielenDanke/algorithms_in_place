package dynamic_programming.java_solutions;

public class DecodeWays_91 {

    static class Solution {

        public int numDecodings(String s) {
            int n = s.length();

            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;

            for (int i = 2; i <= n; i++) {
                int left = Integer.parseInt(s.substring(i - 1, i));
                int afterLeft = Integer.parseInt(s.substring(i - 2, i));
                if (left >= 1 && left <= 9) {
                    dp[i] += dp[i - 1];
                }
                if (afterLeft >= 10 && afterLeft <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }

    static class SolutionBruteForce {

        public int numDecodings(String s) {
            if (s.length() == 0) {
                return 1;
            }
            int sum = 0;
            for (int i = 1; i <= 2 && i <= s.length(); i++) {
                int val = Integer.parseInt(s.substring(0, i));
                if (val >= 1 && val <= 26 && s.charAt(0) != '0') {
                    sum += numDecodings(s.substring(i));
                }
            }
            return sum;
        }
    }
}
