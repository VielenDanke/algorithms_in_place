package strings.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence_Algo {

    /*
    Pattern:
      T H E I R
    H 2 2 1 1 0  0
    A 1 1 1 1 0  0
    B 1 1 1 1 0  0
    I 1 1 1 1 0  0
    T 1 0 0 0 0  0
      0 0 0 0 0

    Idea:
    If i == j -> 1 + dp[i+1][j+1] or 1 + dp[i][j] (depends on prefix or suffix problem solution)
    if i != j -> Math.max(dp[i + 1][j], dp[i][j + 1]
     */

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int N = str2.length();
        int M = str1.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            char left = str2.charAt(i);
            for (int j = 0; j < M; j++) {
                char right = str1.charAt(j);
                if (left == right) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return buildSequence(dp, str1);
    }

    private static List<Character> buildSequence(int[][] dp, String str) {
        List<Character> sequence = new ArrayList<>();
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                sequence.add(0, str.charAt(j - 1));
                i--;
                j--;
            }
        }
        return sequence;
    }
}
