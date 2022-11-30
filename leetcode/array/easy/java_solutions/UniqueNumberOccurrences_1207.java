package leetcode.array.easy.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
