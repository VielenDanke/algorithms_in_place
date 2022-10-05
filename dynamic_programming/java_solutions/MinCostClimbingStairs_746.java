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
            for (int i = 2; i < cost.length; i ++) {
                cost[i] += Math.min(cost[i - 1], cost[i - 2]);
            }
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
    }
}
