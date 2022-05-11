package tree.easy.java_solutions;

import static tree.Helper.*;

public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameSubTree(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSameSubTree(s.left, t.left) && isSameSubTree(s.right, t.right);
    }
}
