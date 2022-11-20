package leetcode.stack.hard.java_solutions;

import java.util.Stack;

public class BasicCalculator_224 {

    static class Solution {
        public static int calculate(String s) {
            int len = s.length(), sign = 1, result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int sum = s.charAt(i) - '0';
                    while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                        sum = sum * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    result += sum * sign;
                } else if (s.charAt(i) == '+')
                    sign = 1;
                else if (s.charAt(i) == '-')
                    sign = -1;
                else if (s.charAt(i) == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (s.charAt(i) == ')') {
                    result = result * stack.pop() + stack.pop();
                }
            }
            return result;
        }
    }
}
