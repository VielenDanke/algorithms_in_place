package leetcode.strings.easy.java_solution;

public class ReverseWordsInAString3_557 {

    static class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                result.append(new StringBuilder(word).reverse());
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
    }

    static class SolutionWithTrim {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                result.append(new StringBuilder(word).reverse());
                result.append(" ");
            }
            return result.toString().trim();
        }
    }

    static class SolutionBruteForce {
        public String reverseWords(String s) {
            StringBuilder temp = new StringBuilder();
            StringBuilder result = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c != ' ') {
                    temp.append(c);
                } else {
                    result.append(temp.reverse());
                    result.append(" ");
                    temp = new StringBuilder();
                }
            }
            if (!temp.isEmpty()) {
                result.append(temp.reverse());
            }
            return result.toString();
        }
    }
}
