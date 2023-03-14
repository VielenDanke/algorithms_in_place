package leetcode.tree.medium.java_solutions;

import java.util.LinkedList;

import static leetcode.tree.Helper.TreeNode;

public class SumRootToLeafNumbers_129 {

    static class SolutionWithList {

        private static final int BASE = 10;
        private int sum;

        public int sumNumbers(TreeNode root) {
            sum = 0;
            findSum(root, new LinkedList<>());
            return sum;
        }

        private void findSum(TreeNode node, LinkedList<Integer> list) {
            if (node == null) return;;
            list.add(node.val);
            if (node.left == null && node.right == null) {
                int tempSum = 0;
                int tempPow = list.size() - 1;
                for (Integer num : list) {
                    tempSum += num * Math.pow(BASE, tempPow--);
                }
                sum += tempSum;
            }
            findSum(node.left, list);
            findSum(node.right, list);
            list.removeLast();
        }
    }

    static class Solution {

        private int sum;

        public int sumNumbers(TreeNode root) {
            this.sum = 0;

            findSum(root, new StringBuilder());

            return sum;
        }

        private void findSum(TreeNode node, StringBuilder builder) {
            if (node.left == null && node.right == null) {
                builder.append(node.val);
                sum += Integer.parseInt(builder.toString());
                builder.deleteCharAt(builder.length() - 1);
                return;
            }
            builder.append(node.val);
            if (node.left != null) {
                findSum(node.left, builder);
            }
            if (node.right != null) {
                findSum(node.right, builder);
            }
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
