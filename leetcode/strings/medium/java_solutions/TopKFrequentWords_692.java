package leetcode.strings.medium.java_solutions;

import java.util.*;

public class TopKFrequentWords_692 {

    private static class SolutionTrie {

        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String word = null;
        }

        private static class Trie {
            TrieNode root = new TrieNode();

            public void addWord(String word) {
                TrieNode temp = root;
                for (char c : word.toCharArray()) {
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new TrieNode();
                    }
                    temp = temp.children[c - 'a'];
                }
                temp.word = word;
            }

            public int collectWords(TrieNode node, List<String> l) {
                if (node == null) return 0;
                int current = 0;
                if (node.word != null) {
                    l.add(node.word);
                    current++;
                }
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        current += collectWords(node.children[i], l);
                    }
                }
                return current;
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> m = new HashMap<>();

            for (String word : words) {
                m.put(word, m.getOrDefault(word, 0) + 1);
            }
            Trie[] buckets = new Trie[words.length];
            for (Map.Entry<String, Integer> e : m.entrySet()) {
                String word = e.getKey();
                int freq = e.getValue();
                if (buckets[freq] == null) {
                    buckets[freq] = new Trie();
                }
                buckets[freq].addWord(word);
            }
            List<String> result = new LinkedList<>();
            int tempK = k;

            for (int i = buckets.length - 1; i >= 0; i--) {
                if (buckets[i] != null) {
                    int collectedWords = buckets[i].collectWords(buckets[i].root, result);
                    if (collectedWords < k) {
                        k -= collectedWords;
                    } else {
                        return result.subList(0, tempK);
                    }
                }
            }
            return result;
        }
    }

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
                m.put(word, m.getOrDefault(word, 0) + 1);
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
