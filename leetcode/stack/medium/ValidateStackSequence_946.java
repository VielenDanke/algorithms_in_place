package leetcode.stack.medium;

import java.util.Stack;

public class ValidateStackSequence_946 {

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();

            if (pushed.length != popped.length) return false;

            int n = popped.length;
            int idx = 0;

            for (int val : popped) {
                while (idx < n && (stack.isEmpty() || stack.peek() != val)) {
                    stack.add(pushed[idx++]);
                }
                if (stack.isEmpty() || stack.pop() != val) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
