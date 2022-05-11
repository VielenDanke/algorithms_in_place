package dynamic_programming.java_solutions;

import java.util.Arrays;

public class CountSortedVowelStrings_1641 {

    /*
    Time Limit Exceeded
     */
    private static final String[] VOWEL = {"a", "e", "i", "o", "u"};
    private int sum;

    public int countVowelStringsBacktrack(int n) {
        backtrack("", n);
        return sum;
    }

    private void backtrack(String temp, int n) {
        if (temp.length() == n) {
            sum++;
            return;
        }
        for (String s : VOWEL) {
            if (!temp.isBlank() && temp.charAt(s.length() - 1) > s.charAt(0)) {
                continue;
            }
            backtrack(temp + s, n);
        }
    }

    // ------------------------------------------------------------------------------------------------

    public int countVowelStringsBacktrackBetter(int n) {
        count(n, 0);
        return sum;
    }

    private void count(int n, int idx) {
        if (n == 0) {
            sum++;
            return;
        }
        if (idx >= VOWEL.length) {
            return;
        }
        count(n - 1, idx);
        count(n, idx + 1);
    }

    // ------------------------------------------------------------------------------------------------

    /*
    Using DP
    n = 1 - [0, 1, 1, 1, 1, 1]
    n = 2 - [0, 1, 2, 3, 4, 5]
     */

    public int countVowelStringsDP(int n) {
        int[] dp = new int[]{0, 1, 1, 1, 1, 1};
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[k] += dp[k - 1];
        return dp[5];
    }

    public int countVowelStringsDP2(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
        return dp[n][5];
    }

    public int countVowelStringsDP3(int n) {
        int vowelSize = 5;
        int[][] dp = new int[n][vowelSize];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = vowelSize - 1; j >= 0; j--) {
                if (j == vowelSize - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
                }
            }
        }
        int sum = 0;

        for (int j = 0; j < vowelSize; j++) {
            sum += dp[n - 1][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings_1641().countVowelStringsDP3(33));
    }
}
