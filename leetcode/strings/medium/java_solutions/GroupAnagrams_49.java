package leetcode.strings.medium.java_solutions;

import java.util.*;

public class GroupAnagrams_49 {

    static class SolutionArrayChar {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, LinkedList<String>> words = new HashMap<>();
            for (String str : strs) {
                char[] alph = new char[26];
                for (int i = 0; i < str.length(); i++) {
                    alph[str.charAt(i) - 'a']++;
                }
                String val = new String(alph);
                words.putIfAbsent(val, new LinkedList<>());
                words.get(val).add(str);
            }
            return new LinkedList<>(words.values());
        }
    }

    static class SolutionArrayInteger {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, LinkedList<String>> words = new HashMap<>();
            for (String str : strs) {
                int[] alph = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    alph[str.charAt(i) - 'a']++;
                }
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < alph[i]; j++) {
                        builder.append(i + 'a');
                    }
                }
                String val = builder.toString();
                words.putIfAbsent(val, new LinkedList<>());
                words.get(val).add(str);
            }
            return new LinkedList<>(words.values());
        }
    }

    static class SolutionSort {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, LinkedList<String>> words = new HashMap<>();
            for (String str : strs) {
                char[] current = str.toCharArray();
                Arrays.sort(current);
                String val = new String(current);
                words.putIfAbsent(val, new LinkedList<>());
                words.get(val).add(str);
            }
            return new LinkedList<>(words.values());
        }
    }
}
