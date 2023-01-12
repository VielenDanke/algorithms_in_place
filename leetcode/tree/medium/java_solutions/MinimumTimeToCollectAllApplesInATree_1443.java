package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.graph.Helpers.buildBidirectedGraph;

public class MinimumTimeToCollectAllApplesInATree_1443 {

    static class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> graph = buildBidirectedGraph(edges);
            return dfs(0, graph, hasApple, new HashSet<>());
        }

        private int dfs(int current, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
            int sum = 0;
            visited.add(current);
            for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    sum += dfs(next, graph, hasApple, visited);
                }
            }
            if ((sum > 0 || hasApple.get(current)) && current != 0) sum += 2;
            return sum;
        }
    }
}
