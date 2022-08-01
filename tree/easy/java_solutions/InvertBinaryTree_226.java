package tree.easy.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static tree.Helper.TreeNode;

public class InvertBinaryTree_226 {

    private static class SolutionQueue {

        public TreeNode invertTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode last = queue.poll();

                if (last == null) {
                    continue;
                }
                TreeNode temp = last.left;
                last.left = last.right;
                last.right = temp;

                queue.add(last.left);
                queue.add(last.right);
            }
            return root;
        }
    }

    private static class Solution {

        public TreeNode invertTree(TreeNode root) {
            invertTreeRecursive(root);
            return root;
        }

        private void invertTreeRecursive(TreeNode node) {
            if (node == null) {
                return;
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            invertTree(node.left);
            invertTree(node.right);
        }
    }
}
