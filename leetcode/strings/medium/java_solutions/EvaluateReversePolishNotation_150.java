package leetcode.strings.medium.java_solutions;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    static class SolutionWithException {
        public int evalRPN(String[] tokens) {
            Stack<Integer> numbers = new Stack<>();

            for (String token : tokens) {
                try {
                    int number = Integer.parseInt(token);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    int q = numbers.pop(), p = numbers.pop();

                    int number = performOperation(q, p, token);

                    numbers.add(number);
                }
            }
            return numbers.pop();
        }

        private int performOperation(int q, int p, String operation) {
            return switch (operation) {
                case "+" -> p + q;
                case "-" -> p - q;
                case "*" -> p * q;
                case "/" -> p / q;
                default -> throw new IllegalArgumentException();
            };
        }
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> numbers = new Stack<>();

            for (String token : tokens) {
                performOperation(numbers, token);
            }
            return numbers.pop();
        }

        private void performOperation(Stack<Integer> numbers, String token) {
            if (numbers.size() < 2) {
                numbers.add(Integer.parseInt(token));
            } else {
                switch (token) {
                    case "+" -> {
                        int q = numbers.pop(), p = numbers.pop();
                        numbers.add(p + q);
                    }
                    case "-" -> {
                        int q = numbers.pop(), p = numbers.pop();
                        numbers.add(p - q);
                    }
                    case "*" -> {
                        int q = numbers.pop(), p = numbers.pop();
                        numbers.add(p * q);
                    }
                    case "/" -> {
                        int q = numbers.pop(), p = numbers.pop();
                        numbers.add(p / q);
                    }
                    default -> numbers.add(Integer.parseInt(token));
                }
            }
        }
    }
}
