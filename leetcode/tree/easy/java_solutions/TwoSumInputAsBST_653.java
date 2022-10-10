package leetcode.tree.easy.java_solutions;

import java.util.HashSet;
import java.util.Set;

import static leetcode.tree.Helper.TreeNode;

public class TwoSumInputAsBST_653 {

    static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> numbers = new HashSet<>();
            return collectNumbers(numbers, root, k);
        }

        private boolean collectNumbers(Set<Integer> numbers, TreeNode root, int k) {
            if (root == null) return false;
            if (numbers.contains(k - root.val)) {
                return true;
            }
            numbers.add(root.val);
            return collectNumbers(numbers, root.left, k) || collectNumbers(numbers, root.right, k);
        }
    }
}
