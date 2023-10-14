package leetcode.dynamic_programming.java_solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PaintingTheWalls_2742 {

    static class Solution {

        private Integer[][] cache;

        public int paintWalls(int[] cost, int[] time) {
            int n = cost.length;
            this.cache = new Integer[n + 1][n + 1];
            return dp(cost, time, 0, n);
        }

        private int dp(int[] cost, int[] time, int idx, int remain) {
            if (remain <= 0) {
                return 0;
            }
            if (idx >= cost.length) {
                return 1 << 30;
            }
            if (cache[idx][remain] != null) {
                return cache[idx][remain];
            }
            int costWithPaint = cost[idx] + dp(cost, time, idx + 1, remain - time[idx] - 1);
            int costWithoutPaint = dp(cost, time, idx + 1, remain);
            return cache[idx][remain] = Math.min(costWithoutPaint, costWithPaint);
        }
    }

    static class SolutionBruteForceDP {
        public int paintWalls(int[] cost, int[] time) {
            return dp(cost, time, 0, new boolean[cost.length]);
        }

        private int dp(int[] cost, int[] time, int reservedTime, boolean[] visited) {
            int totalCost = 1 << 30;
            boolean isVisited = false;
            for (int i = 0; i < cost.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    isVisited = true;
                    if (reservedTime > 0) {
                        totalCost = Math.min(dp(cost, time, reservedTime - 1, visited), totalCost);
                    } else {
                        totalCost = Math.min(dp(cost, time, reservedTime + time[i], visited) + cost[i], totalCost);
                    }
                    visited[i] = false;
                }
            }
            if (!isVisited) {
                return 0;
            }
            return totalCost;
        }
    }

    static class SolutionBruteForce {
        public int paintWalls(int[] cost, int[] time) {
            return findMinBasedOnCost(cost, time);
        }

        public int findMinBasedOnCost(int[] cost, int[] time) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(left -> cost[left]));
            Queue<Integer> descQueue = new PriorityQueue<>(Comparator.comparingInt(left -> -cost[left]));

            for (int i = 0; i < cost.length; i++) {
                queue.offer(i);
                descQueue.offer(i);
            }
            boolean[] visited = new boolean[cost.length];

            int reservedTime = 0, result = 0;

            while (!queue.isEmpty()) {
                Integer minCostIdx = queue.poll();
                if (visited[minCostIdx]) {
                    continue;
                }
                visited[minCostIdx] = true;
                reservedTime += time[minCostIdx];
                result += cost[minCostIdx];
                while (!descQueue.isEmpty() && reservedTime > 0) {
                    Integer theMostExpensiveIdx = descQueue.poll();
                    if (visited[theMostExpensiveIdx]) {
                        continue;
                    }
                    visited[theMostExpensiveIdx] = true;
                    reservedTime--;
                }
            }
            return result;
        }
    }
}
