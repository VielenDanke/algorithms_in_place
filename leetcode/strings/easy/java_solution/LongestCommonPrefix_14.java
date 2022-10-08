package leetcode.strings.easy.java_solution;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix_14 {

    private static class Solution {

        public String longestCommonPrefix(String[] strs) {
            String lowest = null;

            for (String s : strs) {
                if (lowest == null || lowest.length() > s.length()) {
                    lowest = s;
                }
            }
            for (String s : strs) {
                if (!s.startsWith(lowest)) {
                    for (int i = 0; i < lowest.length(); i++) {
                        if (s.charAt(i) != lowest.charAt(i)) {
                            lowest = s.substring(0, i);
                        }
                    }
                }
            }
            return lowest;
        }
    }

    private static class SolutionWithSort {

        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                int current = 0;
                if (!strs[i].startsWith(prefix)) {
                    while (current < prefix.length() && prefix.charAt(current) == strs[i].charAt(current)) {
                        current++;
                    }
                    prefix = prefix.substring(0, current);
                }
            }
            return prefix;
        }
    }
}
