package tree.medium.java_solutions.bfs_dfs;

import tree.Helper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static tree.Helper.*;

public class PopulateNextRightPointersEachNode_117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            Node prev = null;

            for (int i = 0; i < currentSize; i++) {
                Node node = queue.poll();

                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
