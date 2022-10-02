package dynamic_programming.java_solutions;

public class NumberDiceRollsWithTargetSum_1155 {

    private static class SolutionMemo {

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
