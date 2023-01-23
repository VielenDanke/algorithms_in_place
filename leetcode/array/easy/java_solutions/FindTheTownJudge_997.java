package leetcode.array.easy.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge_997 {

    static class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] counter = new int[n + 1];

            for (int[] tr : trust) {
                counter[tr[0]]--;
                counter[tr[1]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (counter[i] == n - 1) return i;
            }
            return -1;
        }
    }

    static class SolutionBruteForce {
        public int findJudge(int n, int[][] trust) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                map.put(i, new HashSet<>());
            }
            for (int[] pair : trust) {
                map.get(pair[0]).add(pair[1]);
            }
            int judge = possibleTownJudge(map);
            if (judge == -1) return judge;
            for (int i = 1; i <= n; i++) {
                if (!map.get(i).contains(judge) && i != judge) return -1;
            }
            return judge;
        }

        private int possibleTownJudge(Map<Integer, Set<Integer>> map) {
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}
