package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static leetcode.tree.Helper.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            boolean isRight = true;

            LinkedList<TreeNode> nodes = new LinkedList<>();

            List<List<Integer>> result = new LinkedList<>();

            if (root == null) return result;

            nodes.offer(root);

            List<Integer> first = new ArrayList<>();

            first.add(root.val);

            result.add(first);

            while (!nodes.isEmpty()) {
                int currentSize = nodes.size();

                List<TreeNode> list = new ArrayList<>();

                List<Integer> toAdd = new ArrayList<>();

                for (int i = 0; i < currentSize; i++) {
                    TreeNode node = nodes.poll();
                    if (node == null) continue;
                    list.add(node.left);
                    list.add(node.right);
                }
                if (isRight) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null) toAdd.add(list.get(i).val);
                    }
                } else {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i) != null) toAdd.add(list.get(i).val);
                    }
                }
                nodes.addAll(list);
                isRight = !isRight;
                if (!toAdd.isEmpty()) result.add(toAdd);
            }
            return result;
        }
    }
}
