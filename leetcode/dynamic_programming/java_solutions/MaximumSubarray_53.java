package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;

public class MaximumSubarray_53 {

    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0], sum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (sum < 0) {
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    static class SolutionDP {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = dp[0];

            for(int i = 1; i < n; i++){
                dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    static class SolutionBruteForce {
        public int maxSubArray(int[] nums) {
            int window = 1;
            int maxSum = -1 << 30;

            while (window <= nums.length) {
                for (int i = 0; i + window <= nums.length; i++) {
                    maxSum = Math.max(maxSum, Arrays.stream(Arrays.copyOfRange(nums, i, i + window))
                            .sum());
                }
                window++;
            }
            return maxSum;
        }
    }
}
