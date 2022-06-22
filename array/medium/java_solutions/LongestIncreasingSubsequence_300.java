package array.medium.java_solutions;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {

    /*
    Pattern, track of maximum increasing subsequence for subproblem [:i]:
    Input - [0, 1, 0, 3, 2, 3]
    1. Init dp array [1, 1, 1, 1, 1, 1]
    2. Iterate over DP array, i = 0 to N, j = 0 to i

    Steps:
    1. index 0 - nothing to do
    2. index 1 - value 1, 1 > 0? Yes - add to dp[1] + 1 and take max of max(dp[0] + 1, dp[1]), dp = [1, 2, 1, 1, 1, 1]
    3. index 2 - value 0, 0 > 0? No, 0 > 1? No - skip
    4. index 3 - value 3, 3 > 0? Yes, max(dp[3], dp[0] + 1) = 2
                          3 > 1? Yes, max(dp[3], dp[1] + 1) = 3
                          3 > 0? Yes, max(dp[3], dp[2] + 1) still 3
    5. index 4 - value 2, repeat the same, max - 3
    6. index 5 - value 3, 3 > 0 = 2, 3 > 1 = 3, 3 > 0 still 3, 3 > 3 - No, 3 > 2 = 4

    Answer - max of dp - 4
     */

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
