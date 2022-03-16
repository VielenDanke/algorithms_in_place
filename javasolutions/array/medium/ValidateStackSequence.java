package javasolutions.array.medium;

import java.util.Stack;

public class ValidateStackSequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : popped) {
            while (j < pushed.length && (stack.isEmpty() || stack.peek() != k)) {
                stack.push(pushed[j]);
                j++;
            }
            if (stack.isEmpty() || stack.peek() != k) {
                return false;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Result: %b\n", ValidateStackSequence.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
