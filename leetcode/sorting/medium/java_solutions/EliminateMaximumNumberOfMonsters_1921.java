package leetcode.sorting.medium.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class EliminateMaximumNumberOfMonsters_1921 {

    static class SolutionSort {
        public int eliminateMaximum(int[] dist, int[] speed) {
            int n = dist.length;
            double[] timeToCity = new double[n];

            for (int i = 0; i < n; i++) {
                timeToCity[i] = (double) dist[i] / speed[i];
            }
            Arrays.sort(timeToCity);

            for (int i = 0; i < n; i++) {
                if (timeToCity[i] <= i) {
                    return i;
                }
            }
            return n;
        }
    }

    static class SolutionQueueFaster {
        public int eliminateMaximum(int[] dist, int[] speed) {
            // n monsters
            // dist - i monster dist (n length)
            // speed - i monster speed (n length)
            // km / min - speed, 1 min - weapon charge
            // dist / speed = time
            int n = dist.length;
            Queue<Double> queue = initializeQueue(n, dist, speed);
            int elimiated = 0;
            while (!queue.isEmpty()) {
                if (queue.peek() - elimiated <= 0) {
                    break;
                }
                elimiated++;
                queue.poll();
            }
            return n - queue.size();
        }

        private Queue<Double> initializeQueue(int n, int[] dist, int[] speed) {
            Queue<Double> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                queue.offer((double) dist[i] / speed[i]);
            }
            return queue;
        }
    }

    static class SolutionQueueBruteForce {
        public int eliminateMaximum(int[] dist, int[] speed) {
            // n monsters
            // dist - i monster dist (n length)
            // speed - i monster speed (n length)
            // km / min - speed, 1 min - weapon charge
            // dist / speed = time
            int n = dist.length;
            Queue<Integer> queue = initializeQueue(n, dist, speed);
            int eliminated = 0;
            while (!queue.isEmpty()) {
                int idx = queue.poll();
                if (dist[idx] <= 0) {
                    return eliminated;
                }
                for (int i = 0; i < n; i++) {
                    dist[i] -= speed[i];
                }
                eliminated++;
            }
            return n;
        }

        private Queue<Integer> initializeQueue(int n, int[] dist, int[] speed) {
            Queue<Integer> queue = new PriorityQueue<>((left, right) -> {
                double leftTime = (double) dist[left] / (double) speed[left];
                double rightTime = (double) dist[right] / (double) speed[right];
                return Double.compare(leftTime, rightTime);
            });
            for (int i = 0; i < n; i++) {
                queue.offer(i);
            }
            return queue;
        }
    }
}
