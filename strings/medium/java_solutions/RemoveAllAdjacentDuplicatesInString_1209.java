package strings.medium.java_solutions;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1209 {

    private static class Letter {
        char c;
        int count;

        private Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) return "";

        Stack<Letter> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(new Letter(c, 1));
            } else {
                if (stack.peek().c == c) {
                    Letter lastLetter = stack.pop();
                    if (++lastLetter.count < k) {
                        stack.add(lastLetter);
                    }
                } else {
                    stack.add(new Letter(c, 1));
                }
            }
        }
        StringBuilder builder = new StringBuilder();

        for (Letter l : stack) {
            builder.append(String.valueOf(l.c).repeat(l.count));
        }
        return builder.toString();
    }

    public String removeDuplicatesTwoPointers(String s, int k) {
        int i = 0;
        int n = s.length();
        int[] count = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
}
