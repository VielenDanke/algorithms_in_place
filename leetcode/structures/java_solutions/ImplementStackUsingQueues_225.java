package leetcode.structures.java_solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

    static class Solution {

        private Queue<Integer> queue = new LinkedList<>();
        private Queue<Integer> stack = new LinkedList<>();

        public Solution() {
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            while (queue.size() > 1) {
                stack.offer(queue.poll());
            }
            int val = queue.poll();
            swap();
            return val;
        }

        public int top() {
            while (queue.size() > 1) {
                stack.offer(queue.poll());
            }
            int val = queue.poll();
            stack.offer(val);
            swap();
            return val;
        }

        public boolean empty() {
            return queue.isEmpty();
        }

        private void swap() {
            Queue<Integer> temp = queue;
            queue = stack;
            stack = temp;
        }
    }

    static class SolutionList {
        private final List<Integer> stack;

        public SolutionList() {
            this.stack = new LinkedList<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        public int pop() {
            int last = top();
            stack.remove(stack.size() - 1);
            return last;
        }

        public int top() {
            int last = -1;
            for (int val : stack) {
                last = val;
            }
            return last;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
