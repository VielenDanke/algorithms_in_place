package leetcode.array.easy.java_solutions;

import java.util.*;

public class UniqueNumberOccurrences_1207 {

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> counter = new HashMap<>();
            Set<Integer> visited = new HashSet<>();

            for (int n : arr) {
                counter.put(n, counter.getOrDefault(n, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                if (!visited.add(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }
    }

    static class SolutionSort {
        public boolean uniqueOccurrences(int[] arr) {
            int[] counter = new int[2001];

            for (int num : arr) {
                counter[num + 1000]++;
            }
            Arrays.sort(counter);

            for (int i = 1; i < counter.length; i++) {
                if (counter[i] == counter[i - 1] && counter[i] > 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class SolutionArray {
        private static final int ARRAY_MAX_SIZE = 2001;

        public boolean uniqueOccurrences(int[] arr) {
            int[] counter = new int[ARRAY_MAX_SIZE];

            for (int num : arr) {
                counter[num + 1000]++;
            }
            int[] unique = new int[ARRAY_MAX_SIZE];

            for (int num : counter) {
                if (num > 0 && unique[num] > 0) {
                    return false;
                }
                unique[num]++;
            }
            return true;
        }
    }
}
