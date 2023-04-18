package leetcode.strings.easy.java_solution;

public class MergeStringsAlternately_1768 {

    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            int n = word1.length(), m = word2.length();
            int left = 0, right = 0;
            StringBuilder builder = new StringBuilder();

            while (left < n || right < m) {
                if (left < n) {
                    builder.append(word1.charAt(left++));
                }
                if (right < m) {
                    builder.append(word2.charAt(right++));
                }
            }
            return builder.toString();
        }
    }

    static class SolutionMergeAsMergeSort {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder builder = new StringBuilder();

            int left = 0, right = 0;
            int n = word1.length(), m = word2.length();
            boolean isLeftTurn = true;

            while (left < n && right < m) {
                if (isLeftTurn) {
                    builder.append(word1.charAt(left++));
                } else {
                    builder.append(word2.charAt(right++));
                }
                isLeftTurn = !isLeftTurn;
            }
            while (left < n) {
                builder.append(word1.charAt(left++));
            }
            while (right < m) {
                builder.append(word2.charAt(right++));
            }
            return builder.toString();
        }
    }
}
