package leetcode.strings.medium.java_solutions;

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

    static class SolutionBruteForce {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            for (int i = 0; i + m <= n; i++) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            for (int i = 0; i + m <= n; i++) {
                int left = i, right = 0;
                while (left < n && right < m && haystack.charAt(left) == needle.charAt(right)) {
                    left++;
                    right++;
                }
                if (right >= m) {
                    return i;
                }
            }
            return -1;
        }
    }
}
