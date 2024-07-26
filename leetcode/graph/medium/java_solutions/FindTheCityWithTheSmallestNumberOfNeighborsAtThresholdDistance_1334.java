package leetcode.graph.medium.java_solutions;

import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance_1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = createGraph(edges);

        int minCities = 1 << 30;
        int city = 0;

        for (int i = 0; i < n; i++) {
            int cities = calculateCities(graph, i, n, distanceThreshold);
            if (cities <= minCities) {
                city = i;
                minCities = cities;
            }
        }
        return city;
    }

    private int calculateCities(Map<Integer, List<int[]>> graph, int start, int n, int distanceThreshold) {
        boolean[] visited = new boolean[n];

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(left -> left[1]));

        queue.offer(new int[]{start, 0});

        int[] results = new int[n];

        Arrays.fill(results, 1 << 30);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            results[current[0]] = Math.min(results[current[0]], current[1]);

            int node = current[0];
            int weight = current[1];

            visited[node] = true;

            for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited[next[0]]) {
                    queue.offer(new int[]{next[0], next[1] + weight});
                }
            }
        }

        int cities = 0;

        for (int i = 0; i < n; i++) {
            if (results[i] <= distanceThreshold) {
                cities++;
            }
        }
        return cities;
    }

    private Map<Integer, List<int[]>> createGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return graph;
    }
}
