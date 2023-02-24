package leetcode.array.medium.java_solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDeviation_1675 {

    static class Solution {
        public int minimumDeviation(int[] nums) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
            int min = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num % 2 == 1) num *= 2;
                queue.add(num);
                min = Math.min(min, num);
            }
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                result = Math.min(result, temp - min);
                if (temp % 2 == 1) break;
                min = Math.min(min, temp / 2);
                queue.add(temp / 2);
            }
            return result;
        }
    }
}
