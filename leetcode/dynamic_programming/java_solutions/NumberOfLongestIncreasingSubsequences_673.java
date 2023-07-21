package leetcode.dynamic_programming.java_solutions;

public class NumberOfLongestIncreasingSubsequences_673 {

    static class Solution {

        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, result = 0, tempMax = 0;
            int[] dp = new int[n], sequences = new int[n];

            for (int i = 0; i < n; i++) {
                dp[i] = sequences[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] == dp[j] + 1) {
                            sequences[i] += sequences[j];
                        }
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            sequences[i] = sequences[j];
                        }
                    }
                }
                if (tempMax == dp[i]) {
                    result += sequences[i];
                }
                if (tempMax < dp[i]) {
                    tempMax = dp[i];
                    result = sequences[i];
                }
            }
            return result;
        }
    }
}
