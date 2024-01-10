package leetcode.graph.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.*;

public class AmountOfTimeForBinaryTreeToBeInfected_2385 {

    static class SolutionDfs {

        private int timeToSpread;

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, start);
            return timeToSpread;
        }

        private int dfs(TreeNode root, int start) {
            if (root == null) return 0;

            int leftDepth = dfs(root.left, start);
            int rightDepth = dfs(root.right, start);

            if (root.val == start) {
                timeToSpread = Math.max(leftDepth, rightDepth);
                return -1;
            } else if (leftDepth >= 0 && rightDepth >= 0) {
                return Math.max(leftDepth, rightDepth) + 1;
            } else {
                timeToSpread = Math.max(timeToSpread, Math.abs(leftDepth - rightDepth));
                return Math.min(leftDepth, rightDepth) - 1;
            }
        }
    }

    static class Solution {
        public int amountOfTime(TreeNode root, int start) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            addToGraph(root, 0, map);
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            int minute = 0;
            Set<Integer> visited = new HashSet<>();
            visited.add(start);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                while (levelSize > 0 && !q.isEmpty()) {
                    int current = q.poll();

                    for (int num : map.get(current)) {
                        if (!visited.contains(num)) {
                            visited.add(num);
                            q.add(num);
                        }
                    }
                    levelSize--;
                }
                minute++;
            }
            return minute - 1;
        }

        private void addToGraph(TreeNode current, int parent, Map<Integer, Set<Integer>> map) {
            if (current == null) {
                return;
            }
            if (!map.containsKey(current.val)) {
                map.put(current.val, new HashSet<>());
            }
            Set<Integer> adjacentList = map.get(current.val);
            if (parent != 0) {
                adjacentList.add(parent);
            }
            if (current.left != null) {
                adjacentList.add(current.left.val);
            }
            if (current.right != null) {
                adjacentList.add(current.right.val);
            }
            addToGraph(current.left, current.val, map);
            addToGraph(current.right, current.val, map);
        }
    }
}
