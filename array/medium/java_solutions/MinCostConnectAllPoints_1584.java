package array.medium.java_solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostConnectAllPoints_1584 {

    private static class Pair<K, V> {
        K key;
        V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(l -> l.key));

        boolean[] visited = new boolean[n];

        heap.add(new Pair<>(0, 0));

        int commonCost = 0;
        int visitedEdges = 0;

        while (visitedEdges < n && !heap.isEmpty()) {
            Pair<Integer, Integer> top = heap.poll();

            int weight = top.key;
            int currentNode = top.value;

            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            commonCost += weight;
            visitedEdges++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nextWeight = Math.abs(points[currentNode][0] - points[i][0]) +
                            Math.abs(points[currentNode][1] - points[i][1]);
                    heap.add(new Pair<>(nextWeight, i));
                }
            }
        }
        return commonCost;
    }
}
