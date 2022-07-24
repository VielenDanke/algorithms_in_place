package strings.medium.java_solutions;

import java.util.Stack;

public class DecodeString_394 {

    private static class Solution {

        private static class Pair {
            String str;
            int idx;

            public Pair(String str, int idx) {
                this.str = str;
                this.idx = idx;
            }
        }

        public String decodeString(String s) {
            return decode(s, 0).str;
        }

        private Pair decode(String s, int start) {
            StringBuilder result = new StringBuilder();

            int digit = 0;

            for (int i = start; i < s.length(); i++) {
                char current = s.charAt(i);

                if (Character.isDigit(current)) {
                    digit = digit * 10 + (current - '0');
                } else if (current == '[') {
                    Pair temp = decode(s, i + 1);
                    result.append(temp.str.repeat(Math.max(0, digit)));
                    digit = 0;
                    i = temp.idx;
                } else if (current == ']') {
                    return new Pair(result.toString(), i);
                } else {
                    result.append(current);
                }
            }
            return new Pair(result.toString(), s.length());
        }
    }

    private static class SolutionIterative {
        private static class Decoder {
            StringBuilder letters;
            int count;

            Decoder(int count) {
                this.letters = new StringBuilder();
                this.count = count;
            }

            public String decodeLetters() {
                return String.valueOf(letters).repeat(Math.max(0, count));
            }
        }

        private StringBuilder result;

        private void appendToEndOFStackIfNotExistsOrToResult(Stack<Decoder> stack, char... chars) {
            if (!stack.isEmpty()) {
                stack.peek().letters.append(chars);
            } else {
                result.append(chars);
            }
        }

        public String decodeString(String s) {
            Stack<Decoder> stack = new Stack<>();

            int count = 0;

            result = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);

                if (Character.isDigit(current)) {
                    count = count * 10 + (current - '0');
                } else if (current == '[') {
                    stack.add(new Decoder(count));
                    count = 0;
                } else if (current == ']') {
                    Decoder last = stack.pop();

                    appendToEndOFStackIfNotExistsOrToResult(stack, last.decodeLetters().toCharArray());
                } else {
                    appendToEndOFStackIfNotExistsOrToResult(stack, current);
                }
            }
            return result.toString();
        }
    }
}
