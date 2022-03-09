package javasolutions.binarytree;

public class ValidateBinaryTree {

    public static boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
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

    public static void main(String[] args) {
        boolean validBST = ValidateBinaryTree.isValidBST(new TreeNode(2147483647));
        System.out.println(validBST);
    }
}
