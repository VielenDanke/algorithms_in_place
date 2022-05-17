package tree.medium.java_solutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import static tree.Helper.TreeNode;

public class FindCorrespondingNode_1379 {

    // The fastest
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        var left = getTargetCopy(original.left, cloned.left, target);
        var right = getTargetCopy(original.right, cloned.right, target);
        if (left == null && right == null) return null;
        return left == null ? right : left;
    }

    public final TreeNode getTargetCopyIterativeBFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode[]> queue = new ArrayDeque<>();

        queue.add(new TreeNode[]{cloned, target});

        while (!queue.isEmpty()) {
            var nodes = queue.poll();

            if (nodes[0] == null) {
                continue;
            }
            if (nodes[0].val == nodes[1].val) {
                return nodes[0];
            }
            queue.add(new TreeNode[]{nodes[0].left, target});
            queue.add(new TreeNode[]{nodes[0].right, target});
        }
        return null;
    }

    public final TreeNode getTargetCopyIterativeDFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode[]> queue = new Stack<>();

        queue.add(new TreeNode[]{cloned, target});

        while (!queue.isEmpty()) {
            var nodes = queue.pop();

            if (nodes[0] == null) {
                continue;
            }
            if (nodes[0].val == nodes[1].val) {
                return nodes[0];
            }
            queue.add(new TreeNode[]{nodes[0].left, target});
            queue.add(new TreeNode[]{nodes[0].right, target});
        }
        return null;
    }
}
