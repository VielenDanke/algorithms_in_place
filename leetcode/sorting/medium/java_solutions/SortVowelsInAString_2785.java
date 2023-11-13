package leetcode.sorting.medium.java_solutions;

import java.util.*;

public class SortVowelsInAString_2785 {

    private static final Set<Character> VOWELS = Set.of('a','e','i','o','u','A','E','I','O','U');

    static class SolutionSort {

        public String sortVowels(String s) {
            List<Character> l = new ArrayList<>();

            for (char c : s.toCharArray()) {
                if (VOWELS.contains(c)) {
                    l.add(c);
                }
            }
            l.sort(Comparator.naturalOrder());

            int idx = 0;
            char[] arr = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                if (VOWELS.contains(s.charAt(i))) {
                    arr[i] = l.get(idx++);
                }
            }
            return new String(arr);
        }
    }

    static class SolutionPriorityQueue {

        public String sortVowels(String s) {
            char[] sc = s.toCharArray();

            Queue<Character> queue = new PriorityQueue<>();

            for (char c : sc) {
                if (VOWELS.contains(c)) {
                    queue.offer(c);
                }
            }
            for (int i = 0; i < sc.length; i++) {
                char c = sc[i];
                if (VOWELS.contains(c) && !queue.isEmpty()) {
                    sc[i] = queue.poll();
                }
            }
            return new String(sc);
        }
    }
}
