package leetcode.strings.easy.java_solution;

import java.util.Stack;

public class MakeTheStringGreat_1544 {

    static class SolutionBuilder {
        public String makeGood(String s) {
            StringBuilder builder = new StringBuilder();
            builder.append(s);
            return dfs(builder).toString();
        }

        private StringBuilder dfs(StringBuilder s) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                    s.deleteCharAt(i);
                    s.deleteCharAt(i);
                    return dfs(s);
                }
            }
            return s;
        }
    }

    static class SolutionStack {
        public String makeGood(String s) {
            Stack<Character> stack = new Stack<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char current = s.charAt(i);
                if (!stack.isEmpty() && Math.abs(stack.peek() - current) == 32) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }
            int m = stack.size();
            char[] letters = new char[m];

            for (int i = m - 1; i >= 0; i--) {
                letters[i] = stack.pop();
            }
            return new String(letters);
        }
    }

    static class SolutionBruteForce {
        public String makeGood(String s) {
            String res;
            while (s.length() > (res = removePair(s)).length()) {
                s = res;
            }
            return res;
        }

        private String removePair(String s) {
            int n = s.length();
            char[] letters = s.toCharArray();
            char symbol = ' ';

            for (int i = 0; i < n - 1; i++) {
                if (Math.abs(letters[i] - letters[i + 1]) == 32) {
                    letters[i] = symbol;
                    letters[i + 1] = symbol;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (char letter : letters) {
                if (letter != symbol) {
                    builder.append(letter);
                }
            }
            return builder.toString();
        }
    }
}
