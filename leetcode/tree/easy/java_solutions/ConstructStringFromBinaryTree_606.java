package leetcode.tree.easy.java_solutions;

import static leetcode.tree.Helper.*;

public class ConstructStringFromBinaryTree_606 {

    private static class Solution {
        public String tree2str(TreeNode root) {
            if (root == null) return "";
            String result = root.val + "";
            String left = tree2str(root.left);
            String right = tree2str(root.right);
            if (left.equals("") && right.equals("")) {
                return result;
            } else if (left.equals("")) {
                return result + "()" + "(" + right + ")";
            } else if (right.equals("")) {
                return result + "(" + left + ")";
            }
            return result + "(" + left + ")" + "(" + right + ")";
        }
    }

    private static class SolutionBuilder {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            dfs(t, sb);
            return sb.toString();
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val);
            if (root.left != null) {
                sb.append("(");
                dfs(root.left, sb);
                sb.append(")");
            }
            if (root.right != null) {
                if (root.left == null) {
                    sb.append("()");
                }
                sb.append("(");
                dfs(root.right, sb);
                sb.append(")");
            }
        }
    }
}
