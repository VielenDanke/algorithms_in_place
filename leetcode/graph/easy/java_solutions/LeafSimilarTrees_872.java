package leetcode.graph.easy.java_solutions;

import leetcode.tree.Helper;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.*;

public class LeafSimilarTrees_872 {

    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            dfs(root1, list1);
            dfs(root2, list2);

            return list1.equals(list2);
        }

        private void dfs(TreeNode node, List<Integer> list) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            if (node.left != null) {
                dfs(node.left, list);
            }
            if (node.right != null) {
                dfs(node.right, list);
            }
        }
    }
}
