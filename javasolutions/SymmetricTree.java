package javasolutions;

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

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();

        System.out.println(st.isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)))));
    }
}
