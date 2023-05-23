package leetcode.system_implementations.java_solutions;

import java.util.*;

public class KthLargestElementInStream_703 {

    static class KthLargest {

        private final Queue<Integer> queue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>(k);
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (!queue.isEmpty() && queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.isEmpty() ? -1 : queue.peek();
        }
    }
}
