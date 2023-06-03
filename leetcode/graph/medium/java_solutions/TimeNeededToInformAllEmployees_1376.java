package leetcode.graph.medium.java_solutions;

import java.util.*;

public class TimeNeededToInformAllEmployees_1376 {

    private static Map<Integer, List<Integer>> buildGraph(int[] manager) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }
        return graph;
    }

    static class SolutionDfs {

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            return dfs(buildGraph(manager), headID, informTime);
        }

        private int dfs(Map<Integer, List<Integer>> graph, int current, int[] informTime) {
            int minutes = 0;
            for (int next : graph.getOrDefault(current, new ArrayList<>())) {
                minutes = Math.max(minutes, dfs(graph, next, informTime));
            }
            return minutes + informTime[current];
        }
    }

    static class SolutionBfs {

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> graph = buildGraph(manager);

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{headID, 0});

            int minutes = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                minutes = Math.max(current[1], minutes);
                for (int next : graph.getOrDefault(current[0], new ArrayList<>())) {
                    queue.offer(new int[]{next, current[1] + informTime[current[0]]});
                }
            }
            return minutes;
        }
    }
}
