package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumIceCreamBars_1833 {

    static class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);

            int amount = 0;

            for (int cost : costs) {
                if (coins - cost >= 0) {
                    coins -= cost;
                } else {
                    break;
                }
                amount++;
            }
            return amount;
        }
    }

    static class SolutionWithArray {
        public int maxIceCream(int[] costs, int coins) {
            int maxCost = -1 << 30;

            for (int cost : costs) maxCost = Math.max(maxCost, cost);

            int[] costCounter = new int[maxCost + 1];

            for (int cost : costs) costCounter[cost]++;

            int numberOfBars = 0;

            for (int cost = 1; cost <= maxCost; cost++) {
                if (coins < cost) {
                    break;
                }
                if (costCounter[cost] != 0) {
                    int count = Math.min(costCounter[cost], coins / cost);
                    coins -= count * cost;
                    numberOfBars += count;
                }
            }
            return numberOfBars;
        }
    }

    static class SolutionWithQueue {
        public int maxIceCream(int[] costs, int coins) {
            Queue<Integer> queue = new PriorityQueue<>();

            for (int cost : costs) queue.add(cost);

            int result = 0;

            while (!queue.isEmpty() && (coins - queue.peek() >= 0)) {
                coins -= queue.poll();
                result++;
            }
            return result;
        }
    }
}
