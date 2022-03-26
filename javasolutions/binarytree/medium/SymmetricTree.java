package javasolutions.binarytree.medium;

import javasolutions.binarytree.TreeNode;

public class SymmetricTree {

    public boolean checkNode(TreeNode checkLeft, TreeNode checkRight) {
        if (checkLeft == null && checkRight == null) {
            return true;
        }
        if (checkLeft == null || checkRight == null) {
            return false;
        } else {
            if (checkLeft.val == checkRight.val) {
                return checkNode(checkLeft.left, checkRight.right) && checkNode(checkLeft.right, checkRight.left);
            } else {
                return false;
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return checkNode(root, root);
    }

}
