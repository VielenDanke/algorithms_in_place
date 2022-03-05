package javasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {

    class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node1 = (Node) o;
            return depth == node1.depth && Objects.equals(node, node1.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, depth);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> nodesByDepth = new HashMap<>();

        Stack<Node> stack = new Stack<>();

        stack.add(new Node(root, 1));

        while (stack.size() > 0) {
            Node node = stack.pop();

            if (nodesByDepth.containsKey(node.depth)) {
                List<Integer> currentDepthNodes = nodesByDepth.get(node.depth);
                currentDepthNodes.add(node.node.val);
                nodesByDepth.put(node.depth, currentDepthNodes);
            } else {
                nodesByDepth.put(node.depth, new ArrayList<>() {{ add(node.node.val); }});
            }
            if (node.node.right != null) {
                stack.add(new Node(node.node.right, node.depth + 1));
            }
            if (node.node.left != null) {
                stack.add(new Node(node.node.left, node.depth + 1));
            }
        }
        return new ArrayList<>(nodesByDepth.values());
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)))));
    }
}
