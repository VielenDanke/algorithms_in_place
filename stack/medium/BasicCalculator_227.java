package stack.medium;

import java.util.Stack;

public class BasicCalculator_227 {

    private static class Solution {

        public int calculate(String s) {
            char lastOperation = '+';
            int lastDigit = 0;
            Stack<Integer> numbers = new Stack<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char current = s.charAt(i);
                if (Character.isDigit(current)) {
                    lastDigit = (lastDigit * 10) + (current - '0');
                }
                if (isExpression(current) || i == n - 1) {
                    performExpression(numbers, lastOperation, lastDigit);
                    lastOperation = current;
                    lastDigit = 0;
                }
            }
            return numbers.stream().mapToInt(Integer::intValue).sum();
        }

        private void performExpression(Stack<Integer> numbers, Character lastExpr, int num) {
            switch (lastExpr) {
                case '*' -> numbers.push(numbers.pop() * num);
                case '/' -> numbers.push(numbers.pop() / num);
                case '+' -> numbers.push(num);
                case '-' -> numbers.push(-num);
                default -> throw new UnsupportedOperationException();
            }
        }

        private boolean isExpression(char ch) {
            return ch == '*' || ch == '/' || ch == '+' || ch == '-';
        }
    }
}
