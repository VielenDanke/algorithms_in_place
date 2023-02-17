package leetcode.tree.easy.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class MinimumDistanceBetweenBSTNodes_783 {

    static class SolutionQueue {
        public int minDiffInBST(TreeNode root) {
            Queue<Integer> queue = new PriorityQueue<>();

            traverse(root, queue);

            Integer prev = null;
            int min = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                if (prev == null) {
                    prev = queue.poll();
                } else {
                    int nextElem = queue.poll();
                    min = Math.min(min, Math.abs(nextElem - prev));
                    prev = nextElem;
                }
            }
            return min;
        }

        private void traverse(TreeNode node, Queue<Integer> queue) {
            if (node == null) return;
            queue.offer(node.val);
            traverse(node.left, queue);
            traverse(node.right, queue);
        }
    }
}
