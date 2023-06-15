package leetcode.tree.medium.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class MaximumLevelSumOfBinaryTree_1161 {

    static class Solution {
        public int maxLevelSum(TreeNode root) {
            if (root == null) return 1;

            int maxSum = Integer.MIN_VALUE;
            int maxSumLevel = 1;
            int level = 1;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                int tempSum = 0;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    tempSum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (maxSum < tempSum) {
                    maxSum = tempSum;
                    maxSumLevel = level;
                }
                level++;
            }
            return maxSumLevel;
        }
    }
}
