package leetcode.backtracking_recursion.java_solutions;

import leetcode.tree.Helper;

import java.util.LinkedList;
import java.util.List;

import static leetcode.tree.Helper.*;

public class UniqueBinarySearchTrees2_95 {

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int left, int right) {
            List<TreeNode> tree = new LinkedList<>();
            if (left > right) {
                tree.add(null);
                return tree;
            }
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTree = generateTrees(left, i - 1);
                List<TreeNode> rightTree = generateTrees(i + 1, right);

                for (TreeNode leftNode : leftTree) {
                    for (TreeNode rightNode : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        tree.add(root);
                    }
                }
            }
            return tree;
        }
    }
}
