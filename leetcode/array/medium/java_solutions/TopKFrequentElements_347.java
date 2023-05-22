package leetcode.array.medium.java_solutions;

import java.util.*;

public class TopKFrequentElements_347 {

    static class Solution {

        private record Pair(int num, int k) {
        }

        public int[] topKFrequent(int[] nums, int k) {
            Queue<Pair> queue = new PriorityQueue<>((l, r) -> r.k - l.k);

            Map<Integer, Integer> m = new HashMap<>();

            for (int n : nums) {
                m.put(n, m.getOrDefault(n, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                queue.offer(new Pair(entry.getKey(), entry.getValue()));
            }
            int[] result = new int[k];
            int counter = 0;

            while (k-- > 0 && !queue.isEmpty()) {
                result[counter++] = queue.poll().num;
            }
            return result;
        }
    }

    static class SolutionTreeMap {

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> m = new HashMap<>();
            TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>((l, r) -> r - l);

            for (int n : nums) {
                m.put(n, m.getOrDefault(n, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                treeMap.putIfAbsent(entry.getValue(), new LinkedList<>());
                treeMap.get(entry.getValue()).add(entry.getKey());
            }
            int[] result = new int[k];
            int counter = 0;

            endOfIteration:
            while (!treeMap.isEmpty()) {
                for (Integer n : treeMap.pollFirstEntry().getValue()) {
                    result[counter++] = n;
                    if (--k <= 0) {
                        break endOfIteration;
                    }
                }
            }
            return result;
        }
    }
}
