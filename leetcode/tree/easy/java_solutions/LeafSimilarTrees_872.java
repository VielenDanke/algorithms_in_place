package leetcode.tree.easy.java_solutions;

import leetcode.tree.Helper;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.*;

public class LeafSimilarTrees_872 {

    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> left = new ArrayList<>(), right = new ArrayList<>();

            dfs(root1, left);
            dfs(root2, right);

            if (left.size() != right.size()) return false;

            for (int i = 0; i < left.size(); i++) {
                if (!left.get(i).equals(right.get(i))) return false;
            }
            return true;
        }

        private void dfs(TreeNode node, List<Integer> values) {
            if (node.left == null && node.right == null) {
                values.add(node.val);
                return;
            }
            if (node.left != null) {
                dfs(node.left, values);
            }
            if (node.right != null) {
                dfs(node.right, values);
            }
        }
    }
}
