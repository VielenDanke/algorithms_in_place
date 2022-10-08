package leetcode.tree.medium.java_solutions;

import java.util.ArrayDeque;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNodeNext;

public class PopulateNextRightPointersEachNode_117 {

    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNodeNext> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            TreeNodeNext prev = null;

            for (int i = 0; i < currentSize; i++) {
                TreeNodeNext treeNodeNext = queue.poll();

                if (prev != null) {
                    prev.next = treeNodeNext;
                }
                prev = treeNodeNext;

                if (treeNodeNext.left != null) {
                    queue.add(treeNodeNext.left);
                }
                if (treeNodeNext.right != null) {
                    queue.add(treeNodeNext.right);
                }
            }
        }
        return root;
    }
}
