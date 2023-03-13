package leetcode.tree.easy.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class SymmetricTree_101 {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val == right.val) return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            return false;
        }
    }

    static class SolutionBruteForce {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                int[] levelArray = new int[levelSize];

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        levelArray[i] = -1 << 30;
                    } else {
                        levelArray[i] = node.val;
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                int left = 0, right = levelArray.length - 1;
                while (left < right) {
                    if (levelArray[left] != levelArray[right]) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
}
