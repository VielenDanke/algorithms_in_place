package leetcode.tree.easy.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.TreeNode;

public class BinaryTreeInOrderTraversal_94 {

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, result);
            return result;
        }

        private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;
            dfs(node.left, result);
            result.add(node.val);
            dfs(node.right, result);
        }
    }
}
