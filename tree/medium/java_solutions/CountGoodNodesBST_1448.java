package tree.medium.java_solutions;

import tree.Helper;

import static tree.Helper.*;

public class CountGoodNodesBST_1448 {

    private static class Solution {

        public int goodNodes(TreeNode root) {
            return goodNodes(root, -1 << 30);
        }

        public int goodNodes(TreeNode root, int maxValue) {
            if (root == null) return 0;
            int res = root.val >= maxValue ? 1 : 0;
            int newMax = Math.max(maxValue, root.val);
            res += goodNodes(root.left, newMax);
            res += goodNodes(root.right, newMax);
            return res;
        }
    }
}
