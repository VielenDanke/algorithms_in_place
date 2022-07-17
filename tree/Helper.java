package tree;

import java.util.List;

public class Helper {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class TreeNodeNext {
        public int val;
        public TreeNodeNext left;
        public TreeNodeNext right;
        public TreeNodeNext next;

        public TreeNodeNext() {
        }

        public TreeNodeNext(int _val) {
            val = _val;
        }

        public TreeNodeNext(int _val, TreeNodeNext _left, TreeNodeNext _right, TreeNodeNext _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
