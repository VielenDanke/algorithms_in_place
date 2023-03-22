package leetcode.graph.medium.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class MinimumScoreBetweenTwoCities_2492 {

    static class SolutionUnionFind {

        private static class UnionFind {
            private final int[] distances;
            private final int[] id;

            private UnionFind(int n) {
                id = new int[n + 1];
                distances = new int[n + 1];

                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    distances[i] = Integer.MAX_VALUE;
                }
            }

            private void union(int i, int j, int dist) {
                int x = find(i);
                int y = find(j);
                id[x] = y;
                int min = Math.min(dist, Math.min(distances[x], distances[y]));
                distances[x] = distances[y] = min;
            }

            private int find(int i) {
                while (i != id[i]) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
        }

        public int minScore(int n, int[][] roads) {
            var uf = new UnionFind(n);

            for (int[] road : roads) {
                uf.union(road[0], road[1], road[2]);
            }
            var group = uf.find(1);
            if (group == uf.find(n)) {
                return uf.distances[group];
            }
            return -1;
        }
    }
    static class SolutionDFS {
        public int minScore(int n, int[][] roads) {
            var visited = new boolean[n + 1];

            var graph = buildGraph(roads);

            visited[1] = true;

            return dfs(1, graph, visited);
        }

        private Integer dfs(int point, Map<Integer, Map<Integer, Integer>> graph, boolean[] visited) {
            var res = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : graph.get(point).entrySet()) {
                res = Math.min(res, entry.getValue());
                if (!visited[entry.getKey()]) {
                    visited[entry.getKey()] = true;
                    res = Math.min(res, dfs(entry.getKey(), graph, visited));
                }
            }
            return res;
        }
    }

    static class SolutionBFS {
        public int minScore(int n, int[][] roads) {
            var queue = new LinkedList<Integer>();

            var m = buildGraph(roads);

            var visited = new HashSet<Integer>();

            var min = Integer.MAX_VALUE;

            queue.offer(1);

            while (!queue.isEmpty()) {
                int nextPoint = queue.poll();

                for (Map.Entry<Integer, Integer> entry : m.get(nextPoint).entrySet()) {
                    if (visited.add(entry.getKey())) {
                        queue.offer(entry.getKey());
                    }
                    min = Math.min(min, entry.getValue());
                }
            }
            return min;
        }
    }

    private static Map<Integer, Map<Integer, Integer>> buildGraph(int[][] roads) {
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();

        for (int[] road : roads) {
            m.putIfAbsent(road[0], new HashMap<>());
            m.putIfAbsent(road[1], new HashMap<>());
            m.get(road[0]).put(road[1], road[2]);
            m.get(road[1]).put(road[0], road[2]);
        }
        return m;
    }
}
