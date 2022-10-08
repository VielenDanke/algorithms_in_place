package leetcode.tree.medium.java_solutions;

import java.util.LinkedList;
import java.util.List;

import static leetcode.tree.Helper.TreeNode;

public class PathSum2_113 {

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new LinkedList<>();

            dfs(list, new LinkedList<>(), root, targetSum);

            return list;
        }

        private void dfs(List<List<Integer>> result, LinkedList<Integer> temp, TreeNode node, int sum) {
            if (node == null) return;
            temp.add(node.val);
            if (node.left == null && node.right == null) {
                if (sum - node.val == 0) {
                    result.add(new LinkedList<>(temp));
                }
            }
            dfs(result, temp, node.left, sum - node.val);
            dfs(result, temp, node.right, sum - node.val);
            temp.removeLast();
        }
    }
}
