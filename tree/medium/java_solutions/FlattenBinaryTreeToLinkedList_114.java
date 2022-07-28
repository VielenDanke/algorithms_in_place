package tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static tree.Helper.*;

public class FlattenBinaryTreeToLinkedList_114 {

    private static class Solution {

        private TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.left = null;
            root.right = prev;
            prev = root;
        }
    }

    private static class SolutionDFS {

        public void flatten(TreeNode root) {
            if (root == null) return;

            List<Integer> l = new ArrayList<>();

            dfs(root, l);

            int current = 0;

            while (current < l.size()) {
                root.val = l.get(current);
                root.left = null;

                if (current == l.size() - 1) {
                    break;
                } else {
                    if (root.right == null) {
                        root.right = new TreeNode();
                    }
                    root = root.right;
                }
                current++;
            }
            root.left = null;
            root.right = null;
        }

        private void dfs(TreeNode node, List<Integer> l) {
            if (node == null) return;
            l.add(node.val);
            dfs(node.left, l);
            dfs(node.right, l);
        }
    }
}
