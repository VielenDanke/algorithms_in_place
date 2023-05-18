package leetcode.graph.medium.java_solutions;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes_1557 {

    static class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            boolean[] seen = new boolean[n];

            for (List<Integer> edge : edges) {
                seen[edge.get(1)] = true;
            }
            List<Integer> result = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (!seen[i]) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    static class SolutionTopologicalSort {
        private Map<Integer, Set<Integer>> graph;

        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> removeCounter = new HashSet<>();
            buildGraph(edges);
            for (int i = 0; i < n; i++) {
                if (!graph.containsKey(i)) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int toRemove = queue.poll();
                for (int key : new ArrayList<>(graph.keySet())) {
                    Set<Integer> set = graph.get(key);
                    if (set.remove(toRemove)) {
                        removeCounter.add(toRemove);
                    }
                    if (set.isEmpty()) {
                        queue.offer(key);
                        graph.remove(key);
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!removeCounter.contains(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        private void buildGraph(List<List<Integer>> edges) {
            graph = new HashMap<>();
            for (List<Integer> edge : edges) {
                graph.putIfAbsent(edge.get(0), new HashSet<>());
                graph.get(edge.get(0)).add(edge.get(1));
            }
        }
    }
}
