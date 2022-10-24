package leetcode.backtracking_recursion.java_solutions;

import java.util.List;

public class MaximumLengthConcatenatedStringUniqueCharacters_1239 {

    static class Solution {
        public int maxLength(List<String> arr) {
            return backtrack(arr, new StringBuilder(), 0);
        }

        private int backtrack(List<String> arr, StringBuilder temp, int start) {
            if (start >= arr.size()) {
                return temp.length();
            }
            int max = temp.length();
            for (int i = start; i < arr.size(); i++) {
                int[] letters = collectLetters(temp.toString(), arr.get(i));
                if (letters != null) {
                    int tempLength = temp.length();
                    temp.append(arr.get(i));
                    max = Math.max(max, backtrack(arr, temp, i + 1));
                    temp.delete(tempLength, temp.length());
                }
            }
            return max;
        }

        /**
         * @param s1 - first String to concatenate
         * @param s2 - second String to concatenate
         * @return null if result of concatenation contains non-unique characters
         * else return counter array of concatenated string
         */
        private int[] collectLetters(String s1, String s2) {
            int[] letters = new int[26];
            for (char c : s1.toCharArray()) {
                letters[c - 'a']++;
            }
            for (char c : s2.toCharArray()) {
                letters[c - 'a']++;
                if (letters[c - 'a'] > 1) {
                    return null;
                }
            }
            return letters;
        }
    }
}
