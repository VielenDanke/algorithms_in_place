package leetcode.tree.medium.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class LongestZigZagPathBinaryTree_1372 {

    static class Solution {

        private int max;

        public int longestZigZag(TreeNode root) {
            this.max = 0;
            zigZagMove(root.left, true, 1);
            zigZagMove(root.right, false, 1);
            return max;
        }

        private void zigZagMove(TreeNode node, boolean direction, int path) {
            if (node == null) return;

            max = Math.max(max, path);

            if (direction) {
                zigZagMove(node.right, !direction, path + 1);
                zigZagMove(node.left, true, 1);
            } else {
                zigZagMove(node.left, !direction, path + 1);
                zigZagMove(node.right, false, 1);
            }
        }
    }

    static class SolutionBruteForce {
        private int max;

        public int longestZigZag(TreeNode root) {
            this.max = 0;
            dfs(root);
            return max;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;

            max = Math.max(max, zigZagMove(node.right, false));
            max = Math.max(max, zigZagMove(node.left, true));

            dfs(node.right);
            dfs(node.left);
        }

        private int zigZagMove(TreeNode node, boolean isParentMoveLeft) {
            if (node == null) return 0;

            int max = 0;

            if (isParentMoveLeft) {
                max = Math.max(max, zigZagMove(node.right, !isParentMoveLeft));
            } else {
                max = Math.max(max, zigZagMove(node.left, !isParentMoveLeft));
            }
            return max + 1;
        }
    }
}
