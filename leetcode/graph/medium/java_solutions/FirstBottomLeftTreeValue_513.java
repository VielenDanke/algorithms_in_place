package leetcode.graph.medium.java_solutions;

import java.util.LinkedList;

import static leetcode.tree.Helper.TreeNode;

public class FirstBottomLeftTreeValue_513 {

    static class SolutionDfs {
        public int findBottomLeftValue(TreeNode root) {
            int[] result = new int[]{0, 0};
            dfs(root, 1, result);
            return result[1];
        }

        private void dfs(TreeNode node, int level, int[] result) {
            if (node == null) {
                return;
            }
            if (level > result[0]) {
                result[0] = level;
                result[1] = node.val;
            }
            dfs(node.left, level + 1, result);
            dfs(node.right, level + 1, result);
        }
    }

    static class SolutionBfs {
        public int findBottomLeftValue(TreeNode root) {
            var queue = new LinkedList<TreeNode>();

            queue.offer(root);

            Integer theMostLeft = null;

            while (!queue.isEmpty()) {
                int n = queue.size();
                Integer firstValue = null;

                for (int i = 0; i < n; i++) {
                    var node = queue.poll();

                    if (node == null) continue;

                    if (firstValue == null) {
                        firstValue = node.val;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                if (firstValue != null) {
                    theMostLeft = firstValue;
                }
            }
            return theMostLeft == null ? -1 : theMostLeft;
        }
    }
}
