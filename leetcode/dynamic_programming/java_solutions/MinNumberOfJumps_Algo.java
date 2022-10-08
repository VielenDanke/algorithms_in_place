package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;

public class MinNumberOfJumps_Algo {

    public static int minNumberOfJumpsDP(int[] array) {
        // Write your code here.
        int N = array.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[N - 1];
    }

    // ----------------------------------------------------------------------------
    // Memo + Brute Force

    private static Integer[] memo;

    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        memo = new Integer[array.length];
        return dfs(array, 0);
    }

    private static int dfs(int[] array, int idx) {
        if (idx >= array.length - 1) {
            return 0;
        }
        if (memo[idx] != null) return memo[idx];
        int min = 1 << 30;
        for (int jump = 1; jump <= array[idx]; jump++) {
            min = Math.min(min, dfs(array, idx + jump) + 1);
        }
        memo[idx] = min;
        return min;
    }
}
