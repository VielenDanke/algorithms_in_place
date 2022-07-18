package tree.easy.java_solutions;

import static tree.Helper.TreeNode;

public class LowestCommonAncestorBST_235 {

    private static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p) {
                return p;
            }
            if (root == q) {
                return q;
            }
            var left = lowestCommonAncestor(root.left, p, q);
            var right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) return root;
            else if (left != null) return left;
            else return right;
        }
    }
}
