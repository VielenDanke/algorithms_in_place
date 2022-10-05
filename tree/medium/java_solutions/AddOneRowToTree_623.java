package tree.medium.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static tree.Helper.TreeNode;

public class AddOneRowToTree_623 {

    static class SolutionDFS {
        /*
        Idea:
        1. If depth == 1 - since 1 is the root depth - we need to replace it and place root to the left of the newRoot
        2. If depth > 1 - move recursively until root != null or depth == 1
        3. If root == null - return null
        4. If depth == 1 - do swap of nodes, current root.left becomes newLeft with new value, and root.right becomes newRight
        5. Append to the left of newLeft root.left value newLeft.left = root.left, and to the right newRight.right = root.right
        6. return with root

        Examples:
         1r 2l 2r 3l 3r 3l - where l - left of root and #n is depth
        [4, 2, 6, 3, 1, 5]

        val = 1, depth = 2

        1. root check if depth is 1 -> NO, moving on, decrease depth by 1
        2. recursive check if depth is 1 -> YES, do swap
                   1r 2l 2r 3l  3r    3l   3r 4r 4l 4r
           we get [4, 1, 1, 2, null, null, 6, 3, 1, 5]
         */

        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            }
            return dfs(root, val, depth - 1);
        }

        private TreeNode dfs(TreeNode root, int val, int depth) {
            if (root == null) {
                return null;
            }
            if (depth == 1) {
                // add row
                TreeNode left = root.left;
                TreeNode right = root.right;
                TreeNode newLeft = new TreeNode(val);
                newLeft.left = left;
                root.left = newLeft;
                TreeNode newRight = new TreeNode(val);
                newRight.right = right;
                root.right = newRight;
                return root;
            }
            root.left = dfs(root.left, val, depth - 1);
            root.right = dfs(root.right, val, depth - 1);
            return root;
        }
    }

    /*
    The same Idea as for recursive, but DFS
    1. Moving until depth - 2 exclusive (depth - 1 - root, depth - 2, all nodes before swap, means we will be swapping
    current.left with newLeft and currentRight with newRight)
    2. On current level - do swap.
    3. Do not forget to check for Null values.
     */

    static class SolutionBFS {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (root == null) return null;

            if (depth == 1) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            }
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            for (int i = 0; i < depth - 2; i++) {
                int currentSize = queue.size();

                for (int j = 0; j < currentSize; j++) {
                    TreeNode current = queue.poll();
                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode newLeft = new TreeNode(val);
                TreeNode newRight = new TreeNode(val);
                newLeft.left = node.left;
                newRight.right = node.right;
                node.left = newLeft;
                node.right = newRight;
            }
            return root;
        }
    }
}
