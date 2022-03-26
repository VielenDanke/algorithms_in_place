package javasolutions.binarytree.easy;

import java.util.Stack;
import javasolutions.binarytree.TreeNode;

public class MaximumDepthBinaryTree {

    private class Node {
        private TreeNode node;
        private int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        Stack<Node> stack = new Stack<>();

        stack.add(new Node(root, 1));

        int maxDepth = -1 << 31;

        while (stack.size() > 0) {
            Node node = stack.pop();

            if (maxDepth < node.depth) {
                maxDepth = node.depth;
            }
            if (node.node.left != null) {
                stack.add(new Node(node.node.left, node.depth + 1));
            }
            if (node.node.right != null) {
                stack.add(new Node(node.node.right, node.depth + 1));
            }
        }
        return maxDepth;
    }

}
