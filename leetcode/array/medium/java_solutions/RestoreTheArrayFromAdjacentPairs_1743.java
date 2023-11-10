package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs_1743 {

    static class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            // element A adjacement with B,C
            // element B adjacement with D,A
            Map<Integer, List<Integer>> m = new HashMap<>();

            for (int[] pair : adjacentPairs) {
                m.putIfAbsent(pair[0], new ArrayList<>());
                m.putIfAbsent(pair[1], new ArrayList<>());
                m.get(pair[0]).add(pair[1]);
                m.get(pair[1]).add(pair[0]);
            }
            for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
                if (entry.getValue().size() == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs(list, entry.getKey(), m);
                    int[] result = new int[list.size()];
                    for (int i = 0; i < result.length; i++) {
                        result[i] = list.get(i);
                    }
                    return result;
                }
            }
            return new int[0];
        }

        private void dfs(List<Integer> result, int nextKey, Map<Integer, List<Integer>> m) {
            if (m.isEmpty() || !m.containsKey(nextKey)) {
                return;
            }
            result.add(nextKey);

            List<Integer> next = m.remove(nextKey);

            for (int num : next) {
                if (num != nextKey) {
                    dfs(result, num, m);
                }
            }
        }
    }
}
