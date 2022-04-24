package tree.medium.java_solutions.bfs_dfs;

import tree.Helper;

import java.util.*;

public class PopulateNextRightPointers_116 {

    public Helper.Node connect(Helper.Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    // ---------------------------------------------------------------------------------------

    public Helper.Node connectIterative(Helper.Node root) {
        Helper.Node start = root;
        while (start != null) {
            Helper.Node current = start;
            while (current != null) {
                if (current.left != null) current.left.next = current.right;
                if (current.right != null && current.next != null) current.right.next = current.next.left;
                current = current.next;
            }
            start = start.left;
        }
        return root;
    }

    // ----------------------------------------------------------------------------------------

    private static class NodeDepth {
        Helper.Node node;
        int depth;

        public NodeDepth(Helper.Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public Helper.Node connectWithMap(Helper.Node root) {
        Queue<NodeDepth> queue = new LinkedList<>();
        Map<Integer, List<Helper.Node>> nodes = new HashMap<>();

        queue.add(new NodeDepth(root, 1));

        while (queue.size() > 0) {
            NodeDepth polledNode = queue.poll();

            if (polledNode.node == null) continue;

            nodes.compute(polledNode.depth, ((key, depthNodes) -> {
                if (depthNodes == null) return new ArrayList<>() {{
                    add(polledNode.node);
                }};
                depthNodes.add(polledNode.node);
                return depthNodes;
            }));
            queue.add(new NodeDepth(polledNode.node.left, polledNode.depth + 1));
            queue.add(new NodeDepth(polledNode.node.right, polledNode.depth + 1));
        }

        nodes.forEach((key, depthNodes) -> {
            Helper.Node currentNode = depthNodes.get(0);

            for (int i = 1; i < depthNodes.size(); i++) {
                currentNode.next = depthNodes.get(i);
                currentNode = depthNodes.get(i);
            }
        });
        return root;
    }
}
