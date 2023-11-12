package leetcode.graph.hard;

import java.util.*;

public class BusRoutes_815 {

    private static class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int n = routes.length;
            Map<Integer, Set<Integer>> destRoutes = new HashMap<>();
            for (int i = 0; i < routes.length; ++i) {
                for (int j : routes[i]) {
                    destRoutes.putIfAbsent(j, new HashSet<>());
                    destRoutes.get(j).add(i);
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{source, 0});

            Set<Integer> visited = new HashSet<>();
            visited.add(source);

            boolean[] visitedRoutes = new boolean[n];

            while (!queue.isEmpty()) {
                int[] nextRouteNode = queue.poll();
                int stop = nextRouteNode[0], numberOfBus = nextRouteNode[1];
                if (stop == target) {
                    return numberOfBus;
                }
                for (int i : destRoutes.get(stop)) {
                    if (visitedRoutes[i]) {
                        continue;
                    }
                    for (int j : routes[i]) {
                        if (!visited.contains(j)) {
                            visited.add(j);
                            queue.offer(new int[]{j, numberOfBus + 1});
                        }
                    }
                    visitedRoutes[i] = true;
                }
            }
            return -1;
        }
    }
}
