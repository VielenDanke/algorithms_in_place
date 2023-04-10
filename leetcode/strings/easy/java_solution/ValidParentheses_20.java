package leetcode.strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    static class Solution {

        private static final Map<Character, Character> PARENTHESES_MAP = new HashMap<>();

        static {
            PARENTHESES_MAP.put(')', '(');
            PARENTHESES_MAP.put('}', '{');
            PARENTHESES_MAP.put(']', '[');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);

                if (!PARENTHESES_MAP.containsKey(current)) {
                    stack.push(current);
                } else {
                    if (stack.isEmpty() || stack.pop() != PARENTHESES_MAP.get(current)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
