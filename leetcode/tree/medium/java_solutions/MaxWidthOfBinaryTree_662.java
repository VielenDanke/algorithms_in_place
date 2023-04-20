package leetcode.tree.medium.java_solutions;

import leetcode.tree.Helper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class MaxWidthOfBinaryTree_662 {

    static class SolutionUsingMap {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            Map<TreeNode, Integer> m = new HashMap<>();

            queue.offer(root);

            m.put(root, 1);

            int maxWidth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                int left = 0, right = 0;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (i == 0) left = m.get(node);
                    if (i == size - 1) right = m.get(node);

                    if(node.left != null){
                        m.put(node.left, m.get(node) * 2);
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        m.put(node.right, m.get(node) * 2 + 1);
                        queue.offer(node.right);
                    }
                }
                maxWidth = Math.max(maxWidth, right - left + 1);
            }
            return maxWidth;
        }
    }

    static class SolutionBruteForce {
        public int widthOfBinaryTree(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            int maxWidth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                Integer left = null, right = null;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (node != null && left == null) {
                        left = i;
                    }
                    if (node != null) {
                        right = i;
                    }
                    if (node == null) {
                        queue.add(null);
                        queue.add(null);
                    } else {
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (left == null) {
                    return maxWidth;
                }
                maxWidth = Math.max(maxWidth, right - left + 1);
            }
            return maxWidth;
        }
    }
}
