package tree.medium.java_solutions;

import static tree.Helper.TreeNode;

public class BinaryTreePruning_814 {

    private static class SolutionShorter {

        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val == 0) return null;
            return root;
        }
    }

    private static class Solution {

        private static class Pair {
            TreeNode node;
            boolean contains;

            Pair() {

            }

            Pair(TreeNode node, boolean contains) {
                this.node = node;
                this.contains = contains;
            }
        }

        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;
            Pair p = dfs(root);
            if (!p.contains && root.val == 0) {
                return null;
            }
            return p.node;
        }

        private Pair dfs(TreeNode root) {
            if (root.left == null && root.right == null) {
                return new Pair(root, root.val == 1);
            }
            Pair left = new Pair();
            Pair right = new Pair();
            if (root.left != null) {
                left = dfs(root.left);
            }
            if (root.right != null) {
                right = dfs(root.right);
            }
            if (!left.contains) {
                root.left = null;
            }
            if (!right.contains) {
                root.right = null;
            }
            return new Pair(root, root.val == 1 || left.contains || right.contains);
        }
    }
}
