package leetcode.graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class MinimuFuelCostToReportToTheCapital_2477 {

    static class Solution {
        private long distance;
        private int seats;

        public long minimumFuelCost(int[][] roads, int seats) {
            List<List<Integer>> graph = buildGraph(roads);
            this.seats = seats;

            dfs(0, 0, graph);
            return distance;
        }

        private int dfs(int point, int prev, List<List<Integer>> graph) {
            int people = 1;
            for (int next : graph.get(point)) {
                if (next == prev) continue;
                people += dfs(next, point, graph);
            }
            if (point != 0) distance += (people + seats - 1) / seats;
            return people;
        }

        private static List<List<Integer>> buildGraph(int[][] edges) {
            int n = edges.length;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            return graph;
        }
    }
}
