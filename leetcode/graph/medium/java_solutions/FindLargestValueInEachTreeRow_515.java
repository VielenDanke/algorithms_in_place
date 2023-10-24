package leetcode.graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class FindLargestValueInEachTreeRow_515 {

    static class SolutionDfs {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list, 0);
            return list;
        }

        private void dfs(TreeNode node, List<Integer> temp, int level) {
            if (node == null) {
                return;
            }
            if (temp.size() == level) {
                temp.add(node.val);
            } else {
                temp.set(level, Math.max(temp.get(level), node.val));
            }
            dfs(node.left, temp, level + 1);
            dfs(node.right, temp, level + 1);
        }
    }

    static class Solution {

        public List<Integer> largestValues(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<Integer> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                int n = queue.size();

                Integer max = null;

                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) continue;
                    max = max == null ? node.val : Math.max(max, node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                if (max != null) {
                    result.add(max);
                }
            }
            return result;
        }
    }
}
