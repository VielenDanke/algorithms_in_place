package dynamic_programming.java_solutions;

public class MinCostClimbingStairs_746 {

    static class SolutionTopDown {
        private Integer[] memo;

        public int minCostClimbingStairs(int[] cost) {
            memo = new Integer[cost.length];
            return Math.min(stepNext(cost, 0), stepNext(cost, 1));
        }

        private int stepNext(int[] array, int idx) {
            if (idx >= array.length) return 0;
            if (memo[idx] != null) return memo[idx];
            int min = Math.min(stepNext(array, idx + 1), stepNext(array, idx + 2)) + array[idx];
            memo[idx] = min;
            return min;
        }
    }

    static class SolutionDP {

        private int minCostClimbingStairs(int[] cost) {
            int N = cost.length;
            int[] dp = new int[N + 1];

            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < N + 1; i++) {
                int min = Math.min(dp[i - 1], dp[i - 2]);
                if (i < N) {
                    min += cost[i];
                }
                dp[i] = min;
            }
            return dp[N];
        }
    }
}
