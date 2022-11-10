package leetcode.strings.easy.java_solution;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    static class Solution {

        public String removeDuplicates(String s) {
            int i = 0, n = s.length();
            char[] res = s.toCharArray();
            for (int j = 0; j < n; j++, i++) {
                res[i] = res[j];
                if (i > 0 && res[i - 1] == res[i]) {
                    i -= 2;
                }
            }
            return new String(res, 0, i);
        }
    }

    static class SolutionBuilder {

        public String removeDuplicates(String s) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                int lastLetterIndex = builder.length() - 1;
                if (!builder.isEmpty() && builder.charAt(lastLetterIndex) == current) {
                    builder.deleteCharAt(lastLetterIndex);
                } else {
                    builder.append(current);
                }
            }
            return builder.toString();
        }
    }

    static class SolutionStack {

        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char current = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == current) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }
            int m = stack.size();
            char[] result = new char[m];

            for (int i = m - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return new String(result);
        }
    }

    static class SolutionBruteForce {

        public String removeDuplicates(String s) {
            String res;
            while ((res = removePair(s)).length() < s.length()) {
                s = res;
            }
            return s;
        }

        private String removePair(String s) {
            StringBuilder builder = new StringBuilder();
            char[] letters = s.toCharArray();
            char symbol = '$';

            for (int i = 0; i < s.length() - 1; i++) {
                if (letters[i] == letters[i + 1]) {
                    letters[i] = symbol;
                    letters[i + 1] = symbol;
                }
            }
            for (char current : letters) {
                if (current != symbol) {
                    builder.append(current);
                }
            }
            return builder.toString();
        }
    }
}
