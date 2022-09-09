package dynamic_programming.java_solutions;

public class DeleteAndEarn_740 {

    static class SolutionRecursive {

        private static final int MAX = 10000;

        public int deleteAndEarn(int[] nums) {
            int[] count = new int[MAX + 1];
            int maxNum = 0;

            for (int num: nums) {
                count[num]++;
                maxNum = Math.max(maxNum, num);
            }

            return deleteAndEarn(maxNum, count);
        }

        private int deleteAndEarn(int num, int[] count) {
            if (num <= 0) return 0;

            return Math.max(deleteAndEarn(num - 2, count) + (count[num] * num),
                    deleteAndEarn(num - 1, count));
        }
    }

    static class SolutionMemo {
        private static final int MAX = 10000;

        public int deleteAndEarn(int[] nums) {
            int[] count = new int[MAX + 1];
            int maxNum = 0;

            for (int num: nums) {
                count[num]++;
                maxNum = Math.max(maxNum, num);
            }
            return deleteAndEarn(maxNum, count, new int[MAX + 1]);
        }

        private int deleteAndEarn(int num, int[] count, int[] memo) {
            if (num <= 0) return 0;
            if (memo[num] > 0) return memo[num];

            memo[num] = Math.max(deleteAndEarn(num - 2, count, memo) + (count[num] * num),
                    deleteAndEarn(num - 1, count, memo));
            return memo[num];
        }
    }

    static class SolutionBottomUp {
        private static final int MAX = 10000;

        public int deleteAndEarn(int[] nums) {
            int[] count = new int[MAX + 1];
            int maxNum = 0;

            for (int num: nums) {
                count[num]++;
                maxNum = Math.max(maxNum, num);
            }
            return deleteAndEarn(maxNum, count);
        }

        private int deleteAndEarn(int maxNum, int[] count) {
            int[] maxPoints = new int[MAX + 1];

            for (int num = 1; num <= maxNum; num++) {
                maxPoints[num] = Math.max(maxPoints[num == 1 ? 0 : num - 2] + (count[num] * num),
                        maxPoints[num - 1]);
            }
            return maxPoints[maxNum];
        }
    }

    static class Solution {

        public int deleteAndEarn(int[] nums) {
            int[] sum = new int[10001];
            for (int num : nums) {
                sum[num] += num;
            }
            int[] dp = new int[10001];
            dp[1] = sum[1];
            for (int i = 2; i <= 10000; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
            }
            return dp[10000];
        }
    }
}
