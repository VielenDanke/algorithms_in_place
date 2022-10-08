package leetcode.dynamic_programming.java_solutions;

public class DeleteAndEarn_740 {

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

    static class Solution {

        public int deleteAndEarn(int[] nums) {
            int[] sum = new int[10002];

            for (int num : nums) {
                sum[num] += num;
            }
            for(int i = 2; i < sum.length; i++){
                sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
            }
            return sum[10001];
        }
    }
}
