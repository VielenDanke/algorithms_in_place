package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.TreeNode;

public class FindModeInBinarySearchTree_501 {

    static class SolutionRecursive {
        private int currentVal;
        private int currentCount = 0;
        private int maxCount = 0;
        private final List<Integer> modes = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inOrderTraversal(root);
            int[] result = new int[modes.size()];
            for (int i = 0; i < modes.size(); i++) {
                result[i] = modes.get(i);
            }
            return result;
        }

        private void inOrderTraversal(TreeNode node) {
            if (node == null) return;

            inOrderTraversal(node.left);

            currentCount = (node.val == currentVal) ? currentCount + 1 : 1;
            if (currentCount == maxCount) {
                modes.add(node.val);
            } else if (currentCount > maxCount) {
                maxCount = currentCount;
                modes.clear();
                modes.add(node.val);
            }
            currentVal = node.val;

            inOrderTraversal(node.right);
        }
    }

    static class Solution {
        public int[] findMode(TreeNode root) {
            // bfs
            // count the most frequent elements
            // return it
            Queue<TreeNode> queue = new LinkedList<>();
            Map<Integer, Integer> counter = new HashMap<>();

            queue.offer(root);
            int max = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) continue;
                    max = Math.max(max, counter.merge(node.val, 1, Integer::sum));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            // using int[100] because of doing conversion from List to Array is boring :D
            // we can change it to List and then do conversion (first add to the list and then to the array)
            int[] result = new int[100];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                if (entry.getValue() == max) {
                    result[idx++] = entry.getKey();
                }
            }
            return Arrays.copyOfRange(result, 0, idx);
        }
    }
}
