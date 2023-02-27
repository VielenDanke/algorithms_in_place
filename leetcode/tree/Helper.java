package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static void dfs(List<Integer> array, TreeNode root) {
        if (root == null) {
            return;
        }
        array.add(root.val);
        dfs(array, root.left);
        dfs(array, root.right);
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

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

        @Override
        public String toString() {
            List<Integer> list = new ArrayList<>();
            dfs(list, this);
            return list.toString();
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

    public static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static class QuadTreeNode {

        public boolean val;
        public boolean isLeaf;
        public QuadTreeNode topLeft;
        public QuadTreeNode topRight;
        public QuadTreeNode bottomLeft;
        public QuadTreeNode bottomRight;

        public QuadTreeNode() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public QuadTreeNode(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public QuadTreeNode(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
