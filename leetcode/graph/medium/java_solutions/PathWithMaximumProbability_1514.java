package leetcode.graph.medium.java_solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaximumProbability_1514 {

    static class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            Map<Integer, Map<Integer, Double>> graph = buildGraph(edges, succProb);

            PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));

            double[] prob = new double[n];

            pq.offer(new double[]{1, start});

            while (!pq.isEmpty()) {
                double[] current = pq.poll();

                int node = (int) current[1];
                double probability = current[0];

                if (node == end) {
                    return probability;
                }
                if (probability > prob[node]) {
                    prob[node] = probability;

                    for (var entry : graph.getOrDefault(node, Map.of()).entrySet()) {
                        int nextNode = entry.getKey();
                        double nextProbability = entry.getValue();
                        pq.offer(new double[]{probability * nextProbability, nextNode});
                    }
                }
            }
            return 0;
        }

        private static Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
            Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                graph.computeIfAbsent(edge[0], m -> new HashMap<>()).put(edge[1], succProb[i]);
                graph.computeIfAbsent(edge[1], m -> new HashMap<>()).put(edge[0], succProb[i]);
            }
            return graph;
        }
    }
}
