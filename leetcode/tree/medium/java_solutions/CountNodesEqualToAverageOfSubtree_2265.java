package leetcode.tree.medium.java_solutions;

import leetcode.tree.Helper;

import static leetcode.tree.Helper.*;

public class CountNodesEqualToAverageOfSubtree_2265 {

    static class Solution {
        int counter = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return counter;
        }

        private int[] dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                counter++;
                return new int[]{node.val, 1};
            }
            int sum = node.val;
            int amount = 1;
            if (node.left != null) {
                int[] leftResult = dfs(node.left);
                amount += leftResult[1];
                sum += leftResult[0];
            }
            if (node.right != null) {
                int[] rightResult = dfs(node.right);
                amount += rightResult[1];
                sum += rightResult[0];
            }
            if (sum / amount == node.val) {
                counter++;
            }
            return new int[]{sum, amount};
        }
    }
}
