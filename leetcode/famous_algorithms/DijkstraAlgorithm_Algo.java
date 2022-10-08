package leetcode.famous_algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAlgorithm_Algo {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        boolean[] visited = new boolean[edges.length];

        pq.add(new int[]{start, 0});

        var result = new int[edges.length];

        Arrays.fill(result, Integer.MAX_VALUE);

        result[start] = 0;

        while (!pq.isEmpty()) {
            var current = pq.poll();
            var currentPos = current[0];
            var currentDis = current[1];

            if (visited[currentPos]) {
                continue;
            }
            result[currentPos] = Math.min(result[currentPos], currentDis);
            visited[currentPos] = true;
            var nextNodes = edges[currentPos];

            for (var node : nextNodes) {
                pq.add(new int[]{node[0], currentDis + node[1]});
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
