package leetcode.tree.medium.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class MaximumProductOfSplittedBinaryTree_1339 {

    static class Solution {
        private static final int MOD = (int) (1e9 + 7);
        private long max;
        private long sum;

        public int maxProduct(TreeNode root) {
            sum = max(root);
            max(root);
            return (int)(max % MOD);
        }

        private long max(TreeNode node) {
            if (node == null) return 0;
            long current = max(node.left) + max(node.right) + node.val;
            max = Math.max(max, (sum - current) * current);
            return current;
        }
    }
}
