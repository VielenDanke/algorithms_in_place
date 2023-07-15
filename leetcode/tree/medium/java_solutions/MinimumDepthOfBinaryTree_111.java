package leetcode.tree.medium.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class MinimumDepthOfBinaryTree_111 {

    static class Solution {

        public int minDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                return 1;
            }
            int min = Integer.MAX_VALUE;
            if (node.left != null) {
                min = Math.min(min, minDepth(node.left));
            }
            if (node.right != null) {
                min = Math.min(min, minDepth(node.right));
            }
            return min + 1;
        }
    }

    static class SolutionWithNoReturnValue {

        private int min;

        public int minDepth(TreeNode root) {
            this.min = Integer.MAX_VALUE;
            dfs(root, 1);
            return min;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                min = 0;
                return;
            }
            if (node.left == null && node.right == null) {
                min = Math.min(min, depth);
                return;
            }
            if (node.left != null) {
                dfs(node.left, depth + 1);
            }
            if (node.right != null) {
                dfs(node.right, depth + 1);
            }
        }
    }
}
