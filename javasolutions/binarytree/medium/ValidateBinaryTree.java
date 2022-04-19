package javasolutions.binarytree.medium;

import javasolutions.binarytree.TreeNode;

public class ValidateBinaryTree {

    public static boolean isValidBST(TreeNode root) {
        return validateBST(root, -1 << 29, 1 << 29);
    }

    private static boolean validateBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        return node.val < max
                && node.val > min
                && validateBST(node.left, min, node.val)
                && validateBST(node.right, node.val, max);
    }

}
