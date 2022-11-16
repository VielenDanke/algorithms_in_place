package leetcode.stack.medium;

import java.util.Stack;

public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
        int N = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        stack.add(-1);

        for (int i = 0; i < N; i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // ----------------------------------------------------------------------------
    // Time Limit

    public int longestValidParenthesesTimeLimit(String s) {
        int N = s.length();
        int max = 0;

        int window = 2;

        while (window <= N) {
            for (int i = 0; i + window <= N; i++) {
                String sub = s.substring(i, i + window);
                if (isValid(sub)) {
                    max = Math.max(max, window);
                }
            }
            window += 2;
        }
        return max;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                stack.add(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
