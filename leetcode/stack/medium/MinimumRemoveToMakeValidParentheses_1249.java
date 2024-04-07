package leetcode.stack.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {

    static class Solution {
        public String minRemoveToMakeValid(String s) {
            char symbol = '#';

            StringBuilder temp = new StringBuilder();

            temp.append(s);

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.add(i);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // identify non valid
                        temp.setCharAt(i, symbol);
                    }
                }
            }
            while (!stack.isEmpty()) {
                // identify non valid
                temp.setCharAt(stack.pop(), symbol);
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (c != symbol) {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }
}
