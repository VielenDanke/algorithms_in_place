package leetcode.tree.hard.java_solutions;

import java.util.*;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class SumOfDistancesInTree_834 {

    static class Solution {
        private int[] res, count;
        private List<Set<Integer>> tree;

        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            tree = new ArrayList<>();
            res = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                tree.add(new HashSet<>());
            }
            for (int[] edge : edges) {
                tree.get(edge[0]).add(edge[1]);
                tree.get(edge[1]).add(edge[0]);
            }
            postOrder(0, -1);
            preOrder(0, -1);
            return res;
        }

        public void postOrder(int root, int pre) {
            for (int i : tree.get(root)) {
                if (i == pre) continue;
                postOrder(i, root);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
            count[root]++;
        }

        public void preOrder(int root, int pre) {
            for (int i : tree.get(root)) {
                if (i == pre) continue;
                res[i] = res[root] - count[i] + count.length - count[i];
                preOrder(i, root);
            }
        }
    }

    static class SolutionBruteForce {

        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            Map<Integer, List<Integer>> graph = buildBidirectionalGraph(edges);

            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[i] = bfs(i, n, graph);
            }
            return result;
        }

        private int bfs(int start, int n, Map<Integer, List<Integer>> graph) {
            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{start, 0});

            boolean[] visited = new boolean[n];

            int sum = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (visited[current[0]]) continue;

                visited[current[0]] = true;

                sum += current[1];

                for (int next : graph.getOrDefault(current[0], Collections.emptyList())) {
                    queue.add(new int[]{next, current[1] + 1});
                }
            }
            return sum;
        }
    }
}
