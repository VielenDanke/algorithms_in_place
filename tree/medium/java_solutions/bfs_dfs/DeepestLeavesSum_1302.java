package tree.medium.java_solutions.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

import static tree.Helper.TreeNode;

public class DeepestLeavesSum_1302 {

    public int deepestLeavesSum(TreeNode root) {
        int[] rootSum = deepest(root, 0);
        return rootSum[1];
    }

    private int[] deepest(TreeNode root, int deep) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new int[]{deep, root.val};
        }
        int[] left = deepest(root.left, deep + 1);
        int[] right = deepest(root.right, deep + 1);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        if (left[0] > right[0]) {
            return left;
        } else if (left[0] < right[0]) {
            return right;
        }
        return new int[]{left[0], left[1] + right[1]};
    }

    // -----------------------------------------------------------------
    // The fastest Recursive (94.34%)

    private int maxLevel = 0;
    private int sum = 0;

    public int deepestLeavesSumFastest(TreeNode root) {
        if (root == null) return 0;
        calculateDeepestLeavesSum(root, 0);
        return sum;
    }

    private void calculateDeepestLeavesSum(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxLevel) {
                sum = node.val;
                maxLevel = depth;
            } else if (depth == maxLevel) {
                sum += node.val;
            }
        }
        calculateDeepestLeavesSum(node.left, depth + 1);
        calculateDeepestLeavesSum(node.right, depth + 1);
    }

    // ------------------------------------------------------------------

    public int deepestLeavesSumIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int i, res = 0;

        while (!queue.isEmpty()) {
            for (i = queue.size() - 1, res = 0; i >= 0; i--) {
                var node = queue.poll();

                res += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
