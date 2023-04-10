package leetcode.graph.hard;

import java.util.*;

public class LargestColorValueInDirectedGraph_1857 {

    static class Solution {

        public int largestPathValue(String colors, int[][] edges) {
            Map<Integer, Set<Integer>> graph = buildGraph(edges);
            int[][] dp = new int[colors.length()][26];

            Queue<Integer> edgesToRemove = new LinkedList<>();

            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    edgesToRemove.add(entry.getKey());
                    dp[entry.getKey()][colors.charAt(entry.getKey()) - 'a'] = 1;
                }
            }

            int result = 0;

            while (!graph.isEmpty() && !edgesToRemove.isEmpty()) {
                int nextEdgeToRemove = edgesToRemove.poll();

                result = Math.max(result, getMax(dp[nextEdgeToRemove]));

                graph.remove(nextEdgeToRemove);

                for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                    for (int i = 0; i < 26; i++) {
                        dp[entry.getKey()][i] = Math.max(dp[entry.getKey()][i], dp[nextEdgeToRemove][i] + (colors.charAt(entry.getKey()) - 'a' == i ? 1 : 0));
                    }
                    entry.getValue().remove(nextEdgeToRemove);
                    if (entry.getValue().isEmpty()) {
                        edgesToRemove.add(entry.getKey());
                    }
                }
            }
            boolean cycleIsNotExists = graph.isEmpty();
            if (cycleIsNotExists) {
                return result;
            }
            return -1;
        }

        private int getMax(int[] num) {
            int max = num[0];
            for (int n : num) {
                max = Math.max(n, max);
            }
            return max;
        }

        private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
            var map = new HashMap<Integer, Set<Integer>>();

            for (int[] edge : edges) {
                map.putIfAbsent(edge[0], new HashSet<>());
                map.putIfAbsent(edge[1], new HashSet<>());
                map.get(edge[0]).add(edge[1]);
            }
            return map;
        }
    }
}
