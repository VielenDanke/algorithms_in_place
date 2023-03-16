package leetcode.tree.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

import static leetcode.tree.Helper.TreeNode;

public class ConstructBinaryTreeFromInorderPostorderTraversal_106 {

    static class SolutionNext {

        private Map<Integer, Integer> inOrderHashMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            inOrderHashMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                inOrderHashMap.put(inorder[i], i);
            }
            return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int inStartIdx, int inEndIdx, int[] postorder, int postStartIdx, int postEndIdx) {
            if (inStartIdx > inEndIdx || postStartIdx > postEndIdx) return null;

            TreeNode root = new TreeNode(postorder[postEndIdx]);

            int rootIdx = inOrderHashMap.get(root.val);

            root.left = buildTree(inStartIdx, rootIdx - 1, postorder, postStartIdx, postStartIdx + rootIdx - inStartIdx - 1);
            root.right = buildTree(rootIdx + 1, inEndIdx, postorder, postStartIdx + rootIdx - inStartIdx, postEndIdx - 1);

            return root;
        }
    }

    static class Solution {

        private int inorderIdx;
        private int postorderIdx;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            inorderIdx = inorder.length - 1;
            postorderIdx = postorder.length - 1;
            return buildTree(inorder, postorder, null);
        }

        private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
            if (postorderIdx < 0) {
                return null;
            }
            TreeNode n = new TreeNode(postorder[postorderIdx--]);

            if (inorder[inorderIdx] != n.val) {
                n.right = buildTree(inorder, postorder, n);
            }
            inorderIdx--;

            if ((end == null) || (inorder[inorderIdx] != end.val)) {
                n.left = buildTree(inorder, postorder, end);
            }
            return n;
        }
    }
}
