package leetcode.graph.medium.java_solutions;

import java.util.*;

public class FindEventualSafeStates_802 {

    static class SolutionTopologicalSort {
            public List<Integer> eventualSafeNodes(int[][] graph) {
                List<Set<Integer>> graphs = new ArrayList<>();

                TreeSet<Integer> result = new TreeSet<>(Comparator.comparingInt(Integer::intValue));

                Queue<Integer> queue = new LinkedList<>();

                for (int i = 0; i < graph.length; i++) {
                    if (graph[i].length == 0) {
                        queue.offer(i);
                        result.add(i);
                        graphs.add(null);
                    } else {
                        Set<Integer> s = new HashSet<>();
                        for (int gr : graph[i]) {
                            s.add(gr);
                        }
                        graphs.add(s);
                    }
                }

                while (!queue.isEmpty()) {
                    int terminal = queue.poll();

                    result.add(terminal);

                    for (int i = 0; i < graphs.size(); i++) {
                        Set<Integer> s = graphs.get(i);
                        if (s == null) continue;
                        s.remove(terminal);
                        if (s.size() == 0) {
                            queue.offer(i);
                            graphs.set(i, null);
                        }
                    }
                }
                return new ArrayList<>(result);
            }
    }

    static class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> res = new ArrayList<>();

            if (graph == null || graph.length == 0) return res;

            int n = graph.length;

            int[] color = new int[n];

            for (int i = 0; i < n; i++) {
                if (dfs(graph, i, color)) {
                    res.add(i);
                }
            }
            return res;
        }

        public boolean dfs(int[][] graph, int start, int[] color) {
            if (color[start] != 0) {
                return color[start] == 1;
            }
            color[start] = 2;

            for (int newNode : graph[start]) {
                if (!dfs(graph, newNode, color)) {
                    return false;
                }
            }
            color[start] = 1;

            return true;
        }
    }

    static class SolutionBruteForce {

        public List<Integer> eventualSafeNodes(int[][] graphNodes) {
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < graphNodes.length; i++) {
                if (dfs(graphNodes, i, new boolean[graphNodes.length])) {
                    answer.add(i);
                }
            }
            return answer;
        }

        private boolean dfs(int[][] graphNodes, int start, boolean[] visited) {
            for (int nextNode : graphNodes[start]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    if (!dfs(graphNodes, nextNode, visited)) {
                        return false;
                    }
                    visited[nextNode] = false;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
