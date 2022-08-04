package tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static tree.Helper.TreeNode;

public class KSmallestElementInBST_230 {

    private static class SolutionWithList {

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> l = new ArrayList<>();
            dfs(l, root);
            return l.get(k - 1);
        }

        private void dfs(List<Integer> l, TreeNode node) {
            if (node == null) return;
            dfs(l, node.left);
            l.add(node.val);
            dfs(l, node.right);
        }
    }

    private static class Solution {
        private int k;
        private int value;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.value = 0;
            dfs(root);
            return this.value;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            if (--k == 0) {
                value = node.val;
                return;
            }
            dfs(node.right);
        }
    }
}
