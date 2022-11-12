package leetcode.system_implementations.java_solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder_295 {

    private final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even && !small.isEmpty() && !large.isEmpty()) {
            return (small.peek() + large.peek()) / 2.0;
        } else if (!small.isEmpty()) {
            return small.peek();
        }
        return -1;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}
