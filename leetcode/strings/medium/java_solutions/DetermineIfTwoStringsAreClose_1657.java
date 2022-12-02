package leetcode.strings.medium.java_solutions;

import java.util.*;

public class DetermineIfTwoStringsAreClose_1657 {

    static class SolutionList {

        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            Map<Character, Integer> word1Map = new HashMap<>();
            Map<Character, Integer> word2Map = new HashMap<>();
            for (char c : word1.toCharArray()) {
                word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
            }
            for (char c : word2.toCharArray()) {
                word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
            }
            if (!word1Map.keySet().equals(word2Map.keySet())) {
                return false;
            }
            List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
            List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
            Collections.sort(word1FrequencyList);
            Collections.sort(word2FrequencyList);
            return word1FrequencyList.equals(word2FrequencyList);
        }
    }

    static class SolutionMap {

        public boolean closeStrings(String word1, String word2) {
        /*
        1. Collect all letters to a hash map <ch, x> where ch - a letter, x - amount of the letter
        2. if we have the same amount of letters - return true
        */
            if (word1.length() != word2.length()) {
                return false;
            }
            final Map<Character, Integer> left = collectLetters(word1);
            final Map<Character, Integer> right = collectLetters(word2);

            if (!left.keySet().equals(right.keySet())) {
                return false;
            }
            final Map<Integer, Integer> counterLeft = collectCounters(left);
            final Map<Integer, Integer> counterRight = collectCounters(right);

            for (Map.Entry<Integer, Integer> entry : counterLeft.entrySet()) {
                Integer value = counterRight.get(entry.getKey());
                if (value == null || !value.equals(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }

        private Map<Integer, Integer> collectCounters(Map<Character, Integer> storage) {
            Map<Integer, Integer> counter = new HashMap<>();

            for (Map.Entry<Character, Integer> entry : storage.entrySet()) {
                counter.put(entry.getValue(), counter.getOrDefault(entry.getValue(), 0) + 1);
            }
            return counter;
        }

        private Map<Character, Integer> collectLetters(String word) {
            Map<Character, Integer> storage = new HashMap<>();

            for (char c : word.toCharArray()) {
                storage.put(c, storage.getOrDefault(c, 0) + 1);
            }
            return storage;
        }
    }
}
