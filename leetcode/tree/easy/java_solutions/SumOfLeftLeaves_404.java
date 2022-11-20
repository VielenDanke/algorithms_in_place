package leetcode.tree.easy.java_solutions;

import leetcode.tree.Helper;

import java.util.Stack;

import static leetcode.tree.Helper.*;

public class SumOfLeftLeaves_404 {

    static class Solution {
        private int sum;

        public int sumOfLeftLeaves(TreeNode root) {
            sum = 0;
            dfs(root);
            return sum;
        }

        public void dfs(TreeNode node) {
            if (isLeaf(node.left)) {
                sum += node.left.val;
            }
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
        }

        public boolean isLeaf(TreeNode node) {
            return node != null && node.left == null && node.right == null;
        }
    }

    static class SolutionStack {
        public int sumOfLeftLeaves(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int sum = 0;

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    if (isLeaf(node.left)) {
                        sum += node.left.val;
                    } else {
                        stack.push(node.left);
                    }
                }
                if (node.right != null && !isLeaf(node.right)) {
                    stack.push(node.right);
                }
            }
            return sum;
        }
    }

    static class SolutionRecursiveReturn {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int sum = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                } else {
                    sum += sumOfLeftLeaves(root.left);
                }
            }
            return sumOfLeftLeaves(root.right) + sum;
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
