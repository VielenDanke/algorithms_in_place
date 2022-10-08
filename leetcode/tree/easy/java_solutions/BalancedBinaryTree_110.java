package leetcode.tree.easy.java_solutions;

import static leetcode.tree.Helper.*;

public class BalancedBinaryTree_110 {

    private static class Pair {
        private final int height;
        private final boolean isValid;

        private Pair(int height, boolean isValid) {
            this.height = height;
            this.isValid = isValid;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxHeight(root).isValid;
    }

    private Pair maxHeight(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }
        Pair left = maxHeight(root.left);
        Pair right = maxHeight(root.right);
        if (Math.abs(left.height - right.height) > 1 || !left.isValid || !right.isValid) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(left.height, right.height) + 1, true);
    }
}
