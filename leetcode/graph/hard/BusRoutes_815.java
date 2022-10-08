package leetcode.graph.hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class BusRoutes_815 {

    private static class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int n = routes.length;
            HashMap<Integer, HashSet<Integer>> destRoutes = new HashMap<>();
            for (int i = 0; i < routes.length; ++i) {
                for (int j : routes[i]) {
                    destRoutes.putIfAbsent(j, new HashSet<>());
                    destRoutes.get(j).add(i);
                }
            }
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {source, 0});
            HashSet<Integer> visited = new HashSet<>();
            visited.add(source);
            boolean[] visitedRoutes = new boolean[n];
            while (!queue.isEmpty()) {
                int stop = queue.peek()[0], bus = queue.peek()[1];
                queue.poll();
                if (stop == target) return bus;
                for (int i : destRoutes.get(stop)) {
                    if (visitedRoutes[i]) continue;
                    for (int j : routes[i]) {
                        if (!visited.contains(j)) {
                            visited.add(j);
                            queue.offer(new int[] {j, bus + 1});
                        }
                    }
                    visitedRoutes[i] = true;
                }
            }
            return -1;
        }
    }
}
