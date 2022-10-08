package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.*;

public class PopulateNextRightPointers_116 {

    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    // ---------------------------------------------------------------------------------------

    public TreeNodeNext connectIterative(TreeNodeNext root) {
        TreeNodeNext start = root;
        while (start != null) {
            TreeNodeNext current = start;
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
        TreeNodeNext treeNodeNext;
        int depth;

        public NodeDepth(TreeNodeNext treeNodeNext, int depth) {
            this.treeNodeNext = treeNodeNext;
            this.depth = depth;
        }
    }

    public TreeNodeNext connectWithMap(TreeNodeNext root) {
        Queue<NodeDepth> queue = new LinkedList<>();
        Map<Integer, List<TreeNodeNext>> nodes = new HashMap<>();

        queue.add(new NodeDepth(root, 1));

        while (queue.size() > 0) {
            NodeDepth polledNode = queue.poll();

            if (polledNode.treeNodeNext == null) continue;

            nodes.compute(polledNode.depth, ((key, depthNodes) -> {
                if (depthNodes == null) return new ArrayList<>() {{
                    add(polledNode.treeNodeNext);
                }};
                depthNodes.add(polledNode.treeNodeNext);
                return depthNodes;
            }));
            queue.add(new NodeDepth(polledNode.treeNodeNext.left, polledNode.depth + 1));
            queue.add(new NodeDepth(polledNode.treeNodeNext.right, polledNode.depth + 1));
        }

        nodes.forEach((key, depthNodes) -> {
            TreeNodeNext currentTreeNodeNext = depthNodes.get(0);

            for (int i = 1; i < depthNodes.size(); i++) {
                currentTreeNodeNext.next = depthNodes.get(i);
                currentTreeNodeNext = depthNodes.get(i);
            }
        });
        return root;
    }
}
