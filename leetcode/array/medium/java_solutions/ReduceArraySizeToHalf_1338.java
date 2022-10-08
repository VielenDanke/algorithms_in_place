package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReduceArraySizeToHalf_1338 {

    private static class Solution {

        public int minSetSize(int[] arr) {
            int size = arr.length;

            Map<Integer, Integer> m = new HashMap<>();

            for (int num : arr) {
                if (m.containsKey(num)) {
                    m.put(num, m.get(num) + 1);
                } else {
                    m.put(num, 1);
                }
            }
            Queue<int[]> queue = new PriorityQueue<>((l, r) -> r[1] - l[1]);

            m.forEach((key, value) -> queue.add(new int[]{key, value}));

            int result = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                size -= current[1];
                result++;
                if (size <= arr.length / 2) {
                    break;
                }
            }
            return result;
        }
    }
}
