package leetcode.tree.easy.java_solutions;

import static leetcode.tree.Helper.TreeNode;

public class IsSameTree_100 {

    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p == null || q == null) {
                return false;
            } else {
                if (p.val != q.val) {
                    return false;
                }
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
