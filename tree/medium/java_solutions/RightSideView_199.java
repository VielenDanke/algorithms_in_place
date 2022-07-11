package tree.medium.java_solutions;

import java.util.*;

import static tree.Helper.TreeNode;

public class RightSideView_199 {

    private static class SolutionQueue {

        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (i == 0) result.add(temp.val);
                    if (temp.right != null) queue.add(temp.right);
                    if (temp.left != null) queue.add(temp.left);
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
