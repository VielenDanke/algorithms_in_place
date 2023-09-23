package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain_1048 {

    static class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int n = words.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            int max = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (isPredecessor(words[j], words[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        private boolean isPredecessor(String before, String next) {
            int n = next.length();
            int m = before.length();
            if (n - m > 1 || n == m) return false;
            int left = 0, right = 0;

            while (left < m && right < n) {
                if (before.charAt(left) == next.charAt(right)) {
                    left++;
                }
                right++;
            }
            return left == m;
        }
    }
}
