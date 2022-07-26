package array.easy.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight_1046 {

    private static class SolutionHeap {

        public int lastStoneWeight(int[] stones) {
            Queue<Integer> queue = new PriorityQueue<>((left, right) -> right - left);

            for (int stone : stones) queue.add(stone);

            while (queue.size() > 1) {
                int first = queue.poll();
                int second = queue.poll();

                if (first != second) {
                    queue.add(Math.abs(first - second));
                }
            }
            return queue.size() == 1 ? queue.poll() : 0;
        }
    }
}
