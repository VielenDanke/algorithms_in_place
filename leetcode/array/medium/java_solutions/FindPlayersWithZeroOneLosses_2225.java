package leetcode.array.medium.java_solutions;

import java.util.*;

public class FindPlayersWithZeroOneLosses_2225 {

    static class SolutionMap {
        public List<List<Integer>> findWinners(int[][] matches) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int[] result : matches) {
                map.putIfAbsent(result[0], 0);
                map.put(result[1], map.getOrDefault(result[1], 0) + 1);
            }
            List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());

            while (!map.isEmpty()) {
                addToResult(answer, map.pollFirstEntry());
            }
            return answer;
        }

        private void addToResult(List<List<Integer>> answer, Map.Entry<Integer, Integer> entry) {
            if (entry.getValue() == 0) {
                answer.get(0).add(entry.getKey());
            }
            if (entry.getValue() == 1) {
                answer.get(1).add(entry.getKey());
            }
        }
    }
}
