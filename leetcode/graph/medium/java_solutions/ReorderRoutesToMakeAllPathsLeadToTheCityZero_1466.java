package leetcode.graph.medium.java_solutions;

import java.util.*;

import static leetcode.graph.Helpers.buildBidirectionalGraph;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {

    static class Solution {
        public int minReorder(int n, int[][] connections) {
            var graph = buildBidirectionalGraph(connections);
            var validator = new Validator(connections);

            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);

            var reorders = 0;

            Set<Integer> visited = new HashSet<>();

            visited.add(0);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (Integer next : graph.get(current)) {
                    if (visited.add(next)) {
                        if (!validator.isConnected(next, current)) {
                            reorders++;
                        }
                        queue.add(next);
                    }
                }
            }
            return reorders;
        }

        private static class Validator {

            private final Map<Integer, Set<Integer>> validatorMap;

            private Validator(int[][] connections) {
                validatorMap = new HashMap<>();
                connectionValidatorBuilder(connections);
            }

            private boolean isConnected(int from, int to) {
                return validatorMap.containsKey(from) && validatorMap.get(from).contains(to);
            }

            private void connectionValidatorBuilder(int[][] connections) {
                for (int[] conn : connections) {
                    validatorMap.putIfAbsent(conn[0], new HashSet<>());
                    validatorMap.get(conn[0]).add(conn[1]);
                }
            }
        }
    }
}
