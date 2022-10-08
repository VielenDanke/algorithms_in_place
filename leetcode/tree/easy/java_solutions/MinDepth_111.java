package leetcode.tree.easy.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 1 << 30;
        int right = 1 << 30;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        if (root.right != null) {
            right = minDepth(root.right);
        }
        return Math.min(left, right) + 1;
    }
}
