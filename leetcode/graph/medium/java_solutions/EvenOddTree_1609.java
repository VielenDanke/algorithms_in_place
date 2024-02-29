package leetcode.graph.medium.java_solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class EvenOddTree_1609 {

    static class SolutionDfsMap {
        private Map<Integer, Integer> levels;

        public boolean isEvenOddTree(TreeNode root) {
            levels = new HashMap<>();
            return dfs(root, 0);
        }

        private boolean dfs(TreeNode root, int level) {
            if (root == null) {
                return true;
            }
            if (level % 2 == 0) {
                if (root.val % 2 == 0) {
                    return false;
                }
                if (levels.get(level) == null) {
                    levels.put(level, root.val);
                } else {
                    if (levels.get(level) >= root.val) {
                        return false;
                    } else {
                        levels.put(level, root.val);
                    }
                }
            } else {
                if (root.val % 2 != 0) {
                    return false;
                }
                if (levels.get(level) == null) {
                    levels.put(level, root.val);
                } else {
                    if (levels.get(level) <= root.val) {
                        return false;
                    } else {
                        levels.put(level, root.val);
                    }
                }
            }
            return dfs(root.left, level + 1) && dfs(root.right, level + 1);
        }
    }

    static class SolutionDfsArray {
        private int[] levels;

        public boolean isEvenOddTree(TreeNode root) {
            levels = new int[100001];
            return dfs(root, 0);
        }

        private boolean dfs(TreeNode root, int level) {
            if (root == null) {
                return true;
            }
            if (level % 2 == 0) {
                if (root.val % 2 == 0) {
                    return false;
                }
                if (levels[level] == 0) {
                    levels[level] = root.val;
                } else {
                    if (levels[level] >= root.val) {
                        return false;
                    } else {
                        levels[level] = root.val;
                    }
                }
            } else {
                if (root.val % 2 != 0) {
                    return false;
                }
                if (levels[level] == 0) {
                    levels[level] = root.val;
                } else {
                    if (levels[level] <= root.val) {
                        return false;
                    } else {
                        levels[level] = root.val;
                    }
                }
            }
            return dfs(root.left, level + 1) && dfs(root.right, level + 1);
        }
    }

    static class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int level = 0;

            while (!queue.isEmpty()) {
                int n = queue.size();

                Integer previousNumber = null;

                for (int i = 0; i < n; i++) {
                    TreeNode currentNode = queue.poll();

                    if (currentNode == null) continue;

                    if (level % 2 == 0 && (currentNode.val % 2 == 0 || (previousNumber != null && previousNumber >= currentNode.val))) {
                        return false;
                    } else if (level % 2 != 0 && (currentNode.val % 2 != 0 || (previousNumber != null && previousNumber <= currentNode.val))) {
                        return false;
                    }
                    previousNumber = currentNode.val;

                    queue.offer(currentNode.left);
                    queue.offer(currentNode.right);
                }
                level++;
            }
            return true;
        }
    }
}
