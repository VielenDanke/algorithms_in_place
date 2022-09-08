package dynamic_programming.java_solutions;

public class ClimbingStairs_70 {

    static class SolutionMemo {
        private Integer[] memo;

        public int climbStairs(int n) {
            memo = new Integer[n + 1];
            return calculateStairs(n);
        }

        private int calculateStairs(int n) {
            if (memo[n] != null) return memo[n];
            if (n < 2) {
                return 1;
            }
            int sum = climbStairs(n - 1) + climbStairs(n - 2);
            memo[n] = sum;
            return sum;
        }
    }

    static class SolutionArray {

        public int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            }
            int[] dp = new int[n + 1];

            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
