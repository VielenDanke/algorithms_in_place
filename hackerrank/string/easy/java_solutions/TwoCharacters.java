package hackerrank.string.easy.java_solutions;

import java.util.*;

public class TwoCharacters {

    static class Solution {

        public static int alternate(String s) {
            List<Character> chars = collectUniqueChars(s);
            Set<char[]> subsets = collectUniqueSubsets(chars);
            return findMax(subsets, s);
        }

        private static int findMax(Set<char[]> subsets, String s) {
            int max = 0;
            for (char[] subset : subsets) {
                StringBuilder builder = new StringBuilder();

                for (char c : s.toCharArray()) {
                    if (c == subset[0] || c == subset[1]) {
                        builder.append(c);
                    }
                }
                if (isValid(builder)) {
                    max = Math.max(max, builder.length());
                }
            }
            return max;
        }

        private static Set<char[]> collectUniqueSubsets(List<Character> chars) {
            Set<char[]> subsets = new HashSet<>();

            for (int i = 0; i < chars.size(); i++) {
                for (int j = i + 1; j < chars.size(); j++) {
                    subsets.add(new char[]{chars.get(i), chars.get(j)});
                }
            }
            return subsets;
        }

        private static List<Character> collectUniqueChars(String s) {
            int[] alph = new int[26];
            List<Character> l = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (alph[c - 'a'] == 0) {
                    alph[c - 'a']++;
                    l.add(c);
                }
            }
            return l;
        }

        private static boolean isValid(StringBuilder builder) {
            for (int i = 0; i + 1 < builder.length(); i++) {
                if (builder.charAt(i) == builder.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
