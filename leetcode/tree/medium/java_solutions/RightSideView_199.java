package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.TreeNode;

public class RightSideView_199 {

    private static class SolutionQueue {

        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            List<Integer> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                Integer theMostRight = null;

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (node != null) {
                        theMostRight = node.val;
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (theMostRight != null) {
                    result.add(theMostRight);
                }
            }
            return result;
        }
    }

    private static class Solution {
        private Set<Integer> set;

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            set = new HashSet<>();

            recursive(result, root, 0);

            return result;
        }

        private void recursive(List<Integer> list, TreeNode node, int depth) {
            if (set.add(depth)) list.add(node.val);

            if (node.right != null) recursive(list, node.right, depth + 1);
            if (node.left != null) recursive(list, node.left, depth + 1);
        }
    }
}
