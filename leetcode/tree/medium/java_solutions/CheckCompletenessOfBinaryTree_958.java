package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.TreeNode;

public class CheckCompletenessOfBinaryTree_958 {

    static class Solution {

        /*
        1. Fulfilling queue until first null element will meet
        2. Polling all null element from the queue until it won't be empty
        3. Check if queue is empty or not - our result, if it is not empty means we have null nodes before non-null ones
         */
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
            while (!queue.isEmpty() && queue.peek() == null) queue.poll();
            return queue.isEmpty();
        }
    }

    static class SolutionBruteForce {

        private Map<Integer, List<TreeNode>> collector;
        private int maxLevel;

        public boolean isCompleteTree(TreeNode root) {
            collector = new HashMap<>();

            collectLevels(root, 1);

            for (Map.Entry<Integer, List<TreeNode>> entry : collector.entrySet()) {
                if (entry.getKey() == maxLevel) {
                    return isLastLevelValid(entry.getValue());
                } else {
                    if (entry.getValue().contains(null)) return false;
                }
            }
            return true;
        }

        private boolean isLastLevelValid(List<TreeNode> list) {
            int idx = 0;
            while (idx < list.size() && list.get(idx) != null) {
                idx++;
            }
            while (idx < list.size() && list.get(idx) == null) {
                idx++;
            }
            return idx == list.size();
        }

        private void collectLevels(TreeNode node, int level) {
            collector.putIfAbsent(level, new ArrayList<>());
            collector.get(level).add(node);
            if (node == null) return;
            maxLevel = Math.max(maxLevel, level);
            collectLevels(node.left, level + 1);
            collectLevels(node.right, level + 1);
        }
    }
}
