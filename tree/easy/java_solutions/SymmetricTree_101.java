package tree.easy.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static tree.Helper.TreeNode;

public class SymmetricTree_101 {

    private static class Solution {
        public boolean checkNode(TreeNode checkLeft, TreeNode checkRight) {
            if (checkLeft == null && checkRight == null) {
                return true;
            }
            if (checkLeft == null || checkRight == null) {
                return false;
            } else {
                if (checkLeft.val == checkRight.val) {
                    return checkNode(checkLeft.left, checkRight.right) && checkNode(checkLeft.right, checkRight.left);
                } else {
                    return false;
                }
            }
        }

        public boolean isSymmetric(TreeNode root) {
            return checkNode(root, root);
        }
    }

    private static class SolutionBruteForce {
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
