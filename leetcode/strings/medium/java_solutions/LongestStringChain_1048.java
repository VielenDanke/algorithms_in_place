package leetcode.strings.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain_1048 {

    /*
    Pattern: https://leetcode.com/problems/longest-string-chain/discuss/2159337/Java-or-DP-or-Based-on-Array
     */

    public int longestStrChain(String[] words) {
        int N = words.length, max = 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 1; i < N; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (words[i].length() > words[j].length() && validate(words[i], words[j])) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] += tempMax;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean validate(String current, String prev) {
        int N = current.length(), M = prev.length();
        if (N - M > 1 || N == M) {
            return false;
        }
        int left = 0, right = 0;

        while (left < M && right < N) {
            if (prev.charAt(left) == current.charAt(right)) {
                left++;
            }
            right++;

        }
        return left == M;
    }
}
