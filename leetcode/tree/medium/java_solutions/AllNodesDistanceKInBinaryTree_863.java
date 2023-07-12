package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.*;

public class AllNodesDistanceKInBinaryTree_863 {

    static class Solution {
        private List<Integer> answer;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            answer = new ArrayList<>();
            findAllNodesInDistanceK(root, target, k);
            return answer;
        }

        private int findAllNodesInDistanceK(TreeNode root, TreeNode target, int k) {
            if (root == null) {
                return -1;
            }
            if (root.val == target.val) {
                findAllChildNodesInDistanceK(root, k);
                return k - 1;
            }
            int left = findAllNodesInDistanceK(root.left, target, k);
            if (left > 0) {
                findAllChildNodesInDistanceK(root.right, left - 1);
                return left - 1;
            }
            int right = findAllNodesInDistanceK(root.right, target, k);
            if (right > 0) {
                findAllChildNodesInDistanceK(root.left, right - 1);
                return right - 1;
            }
            if (left == 0 || right == 0) {
                answer.add(root.val);
            }
            return -1;
        }

        private void findAllChildNodesInDistanceK(TreeNode root, int k) {
            if (k == 0 && root != null) {
                answer.add(root.val);
                return;
            }
            if (root == null) {
                return;
            }
            findAllChildNodesInDistanceK(root.left, k - 1);
            findAllChildNodesInDistanceK(root.right, k - 1);
        }
    }
}
