package leetcode.system_implementations.java_solutions;

import java.util.Stack;

public class MinStack_155 {

    private static class MinStack {

        private final Stack<Integer> stack;
        private Integer currentMin;

        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int val) {
            stack.add(val);
            replaceIfBigger(val);
        }

        public void pop() {
            int current = stack.pop();
            if (current == currentMin) {
                currentMin = null;
                for (Integer num : stack) {
                    replaceIfBigger(num);
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return currentMin;
        }

        private void replaceIfBigger(int val) {
            if (currentMin == null || currentMin > val) {
                currentMin = val;
            }
        }
    }
}
