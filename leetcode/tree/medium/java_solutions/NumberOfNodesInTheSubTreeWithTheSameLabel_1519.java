package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class NumberOfNodesInTheSubTreeWithTheSameLabel_1519 {

    static class Solution {
        private Map<Integer, List<Integer>> graph;
        private Set<Integer> visited;

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            visited = new HashSet<>();
            graph = buildBidirectionalGraph(edges);
            int[] result = new int[labels.length()];
            dfs(0, labels, result);
            return result;
        }

        public int[] dfs(int idx, String labels, int[] result) {
            int[] letters = new int[26];
            if (visited.add(idx)) {
                char currentLabel = labels.charAt(idx);
                for (int next : graph.getOrDefault(idx, Collections.emptyList())) {
                    int[] temp = dfs(next, labels, result);
                    for (int i = 0; i < 26; i++) {
                        letters[i] += temp[i];
                    }
                }
                result[idx] = ++letters[currentLabel - 'a'];
            }
            return letters;
        }
    }
}
