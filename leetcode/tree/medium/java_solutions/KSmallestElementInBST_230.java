package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static leetcode.tree.Helper.TreeNode;

public class KSmallestElementInBST_230 {

    private static class SolutionWithList {

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> l = new ArrayList<>();
            dfs(l, root);
            return l.get(k - 1);
        }

        private void dfs(List<Integer> l, TreeNode node) {
            if (node == null) return;
            dfs(l, node.left);
            l.add(node.val);
            dfs(l, node.right);
        }
    }

    private static class SolutionStack {

        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            pushLeft(stack, root);
            while (--k > 0) {
                pushLeft(stack, stack.pop().right);
            }
            return stack.pop().val;
        }
        private void pushLeft(Stack<TreeNode> stack, TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    private static class Solution {
        private int k;
        private int value;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.value = 0;
            dfs(root);
            return this.value;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            if (--k == 0) {
                value = node.val;
                return;
            }
            dfs(node.right);
        }
    }
}
