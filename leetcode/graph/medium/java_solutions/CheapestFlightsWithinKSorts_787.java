package leetcode.graph.medium.java_solutions;

import java.util.*;

public class CheapestFlightsWithinKSorts_787 {

    private static List[] convertToGraph(int[][] flights, int n) {
        List[] arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<int[]>();
        }
        for (int[] flight : flights) {
            arr[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        return arr;
    }

    static class SolutionDfsMemo {

        private Integer[][] cache;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            cache = new Integer[n][k + 1];
            return Objects.requireNonNullElse(dfs(convertToGraph(flights, n), src, dst, k), -1);
        }

        private Integer dfs(List[] graph, int current, int dst, int k) {
            if (k == -1 && current != dst) {
                return null;
            }
            if (current == dst) {
                return 0;
            }
            if (cache[current][k] != null) {
                return cache[current][k];
            }
            Integer min = null;
            for (int[] possible : (List<int[]>) graph[current]) {
                Integer result = dfs(graph, possible[0], dst, k - 1);
                if (result != null) {
                    if (min == null) {
                        min = result + possible[1];
                    } else {
                        min = Math.min(min, result + possible[1]);
                    }
                }
            }
            cache[current][k] = min;
            return min;
        }
    }

    static class Solution {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(left -> left[1]));

            List[] graph = convertToGraph(flights, n);

            int[] distances = new int[n];
            Arrays.fill(distances, -1);

            int[] moves = new int[n];
            Arrays.fill(moves, Integer.MAX_VALUE);

            queue.offer(new int[]{src, 0, 0});

            while (!queue.isEmpty()) {
                int[] currentNode = queue.poll();
                int current = currentNode[0];
                int next = currentNode[1];
                int distance = currentNode[2];

                if (moves[current] < distance) {
                    continue;
                }
                moves[current] = distance;

                for (int[] possible : (List<int[]>) graph[current]) {
                    int possibleNext = possible[0];
                    int possibleNextDistance = possible[1];

                    int sumCurrentNextDistances = possibleNextDistance + next;

                    if (distances[possibleNext] == -1 || sumCurrentNextDistances < distances[possibleNext]) {
                        distances[possibleNext] = sumCurrentNextDistances;
                    }
                    if (k != distance) {
                        queue.offer(new int[]{possibleNext, sumCurrentNextDistances, distance + 1});
                    }
                }
            }
            return distances[dst];
        }
    }
}
