package leetcode.strings.medium.java_solutions;

import java.util.*;

public class SortCharactersByFrequency_451 {

    static class SolutionQueue {

        private static class Pair {
            int counter;
            char c;

            Pair(int counter, char c) {
                this.counter = counter;
                this.c = c;
            }
        }

        public String frequencySort(String s) {
            Map<Character, Integer> counter = new HashMap<>();

            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
            Queue<Pair> queue = new PriorityQueue<>((i, j) -> j.counter - i.counter);

            counter.forEach((key, value) -> queue.add(new Pair(value, key)));

            StringBuilder result = new StringBuilder();

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();

                result.append(String.valueOf(pair.c).repeat(Math.max(0, pair.counter)));
            }
            return result.toString();
        }
    }

    static class Solution {
        public String frequencySort(String s) {
            TreeMap<Integer, List<Character>> map = new TreeMap<>();

            Map<Character, Integer> counter = new HashMap<>();

            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                map.putIfAbsent(entry.getValue(), new LinkedList<>());
                map.get(entry.getValue()).add(entry.getKey());
            }
            StringBuilder builder = new StringBuilder();
            while (!map.isEmpty()) {
                Map.Entry<Integer, List<Character>> entry = map.pollLastEntry();

                int amount = entry.getKey();

                for (Character c : entry.getValue()) {
                    builder.append(String.valueOf(c).repeat(Math.max(0, amount)));
                }
            }
            return builder.toString();
        }
    }
}
