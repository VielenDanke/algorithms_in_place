package system_implementations.java_solutions;

import java.util.Stack;

public class ImplementQueueUsingStack_232 {

    private static class MyQueue {

        private final Stack<Integer> input;
        private final Stack<Integer> output;

        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        public void push(int x) {
            input.add(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.add(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
