package leetcode.tree.medium.java_solutions;

import leetcode.tree.Helper;

import static leetcode.tree.Helper.TreeNode;

public class CountCompleteTreeNode_222 {

    static class Solution {

        public int countNodes(TreeNode root) {
            int h = findHeight(root);
            return h < 0 ? 0 : findHeight(root.right) == h - 1 ? (1 << h) + countNodes(root.right) :
                    (1 << h - 1) + countNodes(root.left);
        }

        private int findHeight(TreeNode root) {
            return root == null ? -1 : 1 + findHeight(root.left);
        }
    }
}
