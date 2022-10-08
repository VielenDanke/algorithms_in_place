package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static leetcode.tree.Helper.*;

public class BinaryTreeLevelOrderTraversal_102 {

    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            var result = new ArrayList<List<Integer>>();

            if (root == null) return result;

            var queue = new LinkedList<TreeNode>();

            queue.add(root);

            while (!queue.isEmpty()) {
                var levelSize = queue.size();

                var levelList = new ArrayList<Integer>();

                for (int i = 0; i < levelSize; i++) {
                    var node = queue.poll();
                    levelList.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                result.add(levelList);
            }
            return result;
        }
    }
}
