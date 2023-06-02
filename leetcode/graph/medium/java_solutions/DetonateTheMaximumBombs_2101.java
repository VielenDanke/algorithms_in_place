package leetcode.graph.medium.java_solutions;

import java.util.*;

public class DetonateTheMaximumBombs_2101 {

    private static boolean isBombReachable(int[][] bombs, int i, int j) {
        long deltaX = bombs[i][0] - bombs[j][0];
        long deltaY = bombs[i][1] - bombs[j][1];
        long radius = bombs[i][2];
        long distance = deltaX * deltaX + deltaY * deltaY;
        return radius * radius >= distance;
    }

    private static boolean isBombReachable(int[] current, int[] next) {
        long deltaX = current[0] - next[0];
        long deltaY = current[1] - next[1];
        long radius = current[2];
        long distance = deltaX * deltaX + deltaY * deltaY;
        return radius * radius >= distance;
    }

    static class SolutionBfs {
        public int maximumDetonation(int[][] bombs) {
            int maxBombs = 1;

            for (int i = 0; i < bombs.length; i++) {
                maxBombs = Math.max(maxBombs, bfs(bombs, i));
            }
            return maxBombs;
        }

        private int bfs(int[][] bombs, int idx) {
            int n = bombs.length, counter = 0;

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(bombs[idx]);

            boolean[] visited = new boolean[n];

            visited[idx] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                counter++;

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && isBombReachable(current, bombs[i])) {
                        visited[i] = true;
                        queue.offer(bombs[i]);
                    }
                }
            }
            return counter;
        }
    }

    static class SolutionDfsWithoutMap {
        public int maximumDetonation(int[][] bombs) {
            int maxBombs = 1;

            for (int i = 0; i < bombs.length; i++) {
                boolean[] visited = new boolean[bombs.length];
                visited[i] = true;
                maxBombs = Math.max(maxBombs, dfs(bombs, i, visited));
            }
            return maxBombs;
        }

        private int dfs(int[][] bombs, int idx, boolean[] visited) {
            int counter = 1;
            for (int i = 0; i < bombs.length; i++) {
                if (!visited[i] && isBombReachable(bombs, idx, i)) {
                    visited[i] = true;
                    counter += dfs(bombs, i, visited);
                }
            }
            return counter;
        }
    }

    static class SolutionDfsMap {

        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int i = 0; i < n; i++) {
                graph.putIfAbsent(i, new ArrayList<>());
                for (int j = 0; j < n; j++) {
                    if (i != j && isBombReachable(bombs, i, j)) {
                        graph.get(i).add(j);
                    }
                }
            }
            int maxBombs = 1;

            for (int i = 0; i < n; i++) {
                boolean[] visited = new boolean[n];
                visited[i] = true;
                maxBombs = Math.max(maxBombs, dfs(graph, i, visited));
            }
            return maxBombs;
        }

        private int dfs(Map<Integer, List<Integer>> graph, int idx, boolean[] visited) {
            int counter = 1;
            for (Integer next : graph.getOrDefault(idx, new ArrayList<>())) {
                if (!visited[next]) {
                    visited[next] = true;
                    counter += dfs(graph, next, visited);
                }
            }
            return counter;
        }
    }
}
