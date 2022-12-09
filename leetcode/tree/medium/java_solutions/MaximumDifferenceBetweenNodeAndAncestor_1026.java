package leetcode.tree.medium.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    static class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        public int dfs(TreeNode root, int min, int max) {
            if (root == null) return max - min;
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
            return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
        }
    }
}
