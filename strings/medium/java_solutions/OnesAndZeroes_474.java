package strings.medium.java_solutions;

import java.util.*;

public class OnesAndZeroes_474 {

    // DP

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray())
                if (c == '0') zeros++;
                else ones++;
            for (int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }
        return dp[m][n];
    }

    // ----------------------------------------------------------------------------------

    public int findMaxFormTimeLimit(String[] strs, int m, int n) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strs));

        int[][] pairs = new int[strs.length][2];
        int current = 0;

        for (String s : strs) {
            int zero = 0, one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
                if (c == '1') {
                    one++;
                }
            }
            pairs[current++] = new int[]{zero, one};
        }
        return backtrack(strs, pairs, m, n, 0);
    }

    private int backtrack(String[] strs, int[][] pairs, int m, int n, int start) {
        int max = 0;
        for (int i = start; i < strs.length; i++) {
            int[] pair = pairs[i];
            int newM = m - pair[0], newN = n - pair[1];
            if (newM < 0 || newN < 0) {
                continue;
            }
            max = Math.max(backtrack(strs, pairs, newM, newN, i + 1) + 1, max);
        }
        return max;
    }
}
