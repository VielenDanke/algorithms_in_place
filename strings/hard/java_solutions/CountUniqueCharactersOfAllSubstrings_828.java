package strings.hard.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUniqueCharactersOfAllSubstrings_828 {

    static class Solution {
        // https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/1605697/Java-Easy-to-understand-solution-with-detailed-explanation-and-pictures

        public int uniqueLetterString(String s) {
            Map<Character, List<Integer>> indexMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                indexMap.computeIfAbsent(s.charAt(i), ArrayList::new).add(i);
            }
            int result = 0;

            for (Map.Entry<Character, List<Integer>> entry : indexMap.entrySet()) {

                List<Integer> allOccurrences = entry.getValue();

                int size = allOccurrences.size();

                for (int i = 0; i < size; i++) {
                    int currentIndex = allOccurrences.get(i);

                    int left = i == 0 ?
                            currentIndex :
                            currentIndex - allOccurrences.get(i - 1) - 1;

                    int right = i == allOccurrences.size() - 1 ?
                            s.length() - currentIndex - 1 :
                            allOccurrences.get(i + 1) - currentIndex - 1;

                    result += 1 + left + (right * (left + 1));
                }
            }
            return result;
        }
    }

    static class SolutionBruteForce {
        public int uniqueLetterString(String s) {
            Map<String, Integer> substrings = collectAllSubstrings(s);

            int result = 0;

            for (Map.Entry<String, Integer> entry : substrings.entrySet()) {
                result += countUniqueChars(entry.getKey()) * entry.getValue();
            }
            return result;
        }

        private Map<String, Integer> collectAllSubstrings(String s) {
            int right = 1, n = s.length();

            Map<String, Integer> map = new HashMap<>();

            while (right <= n) {
                for (int i = 0; i + right <= n; i++) {
                    String sub = s.substring(i, i + right);
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }
                right++;
            }
            return map;
        }

        private int countUniqueChars(String s) {
            int maxWordAscii = 124;
            int[] counter = new int[maxWordAscii];
            int uniqueCounter = 0;

            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'A']++;
            }
            for (int i = 0; i < maxWordAscii; i++) {
                if (counter[i] == 1) {
                    uniqueCounter++;
                }
            }
            return uniqueCounter;
        }
    }
}
