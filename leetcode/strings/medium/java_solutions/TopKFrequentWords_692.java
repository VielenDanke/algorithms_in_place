package leetcode.strings.medium.java_solutions;

import java.util.*;

public class TopKFrequentWords_692 {

    private static class Solution {

        private static class Pair {
            String word;
            int freq;

            Pair(String word, int freq) {
                this.word = word;
                this.freq = freq;
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> m = new HashMap<>();

            for (String word : words) {
                if (m.containsKey(word)) {
                    m.put(word, m.get(word) + 1);
                } else {
                    m.put(word, 1);
                }
            }
            Queue<Pair> queue = new PriorityQueue<>((left, right) -> {
                if (left.freq == right.freq) {
                    return left.word.compareTo(right.word);
                }
                return right.freq - left.freq;
            });

            for (Map.Entry<String, Integer> entry : m.entrySet()) {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            }
            List<String> result = new ArrayList<>();

            while (k-- > 0 && !queue.isEmpty()) {
                result.add(queue.poll().word);
            }
            return result;
        }
    }
}
