package leetcode.tree.easy.java_solutions;

import static leetcode.tree.Helper.*;

public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameSubTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSameSubTree(s.left, t.left) && isSameSubTree(s.right, t.right);
    }

    // ----------------------------------------------------------------------------

    /*
    Using pre-order traversal
     */

    public boolean isSubtreePreOrder(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null) return false;

        StringBuilder rootSb = new StringBuilder();
        StringBuilder subRootSb = new StringBuilder();

        preOrderTraversal(rootSb, root);
        preOrderTraversal(subRootSb, subRoot);

        return rootSb.toString().contains(subRootSb.toString());
    }

    private void preOrderTraversal(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("$");
            return;
        }
        sb.append("#").append(node.val);
        preOrderTraversal(sb, node.left);
        preOrderTraversal(sb, node.right);
    }
}
