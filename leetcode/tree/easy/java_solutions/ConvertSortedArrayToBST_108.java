package leetcode.tree.easy.java_solutions;

import java.util.Arrays;

import static leetcode.tree.Helper.TreeNode;

public class ConvertSortedArrayToBST_108 {

    private static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            int middle = nums.length / 2;
            TreeNode node = new TreeNode(nums[middle]);
            node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, nums.length));
            return node;
        }
    }

    private static class SolutionWithoutCopyArray {

        public TreeNode sortedArrayToBST(int[] nums) {
            return recursiveToBST(nums, 0, nums.length - 1);
        }

        private TreeNode recursiveToBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int middle = (left + right) / 2;
            TreeNode node = new TreeNode(nums[middle]);
            node.left = recursiveToBST(nums, left, middle - 1);
            node.right = recursiveToBST(nums, middle + 1, right);
            return node;
        }
    }
}
