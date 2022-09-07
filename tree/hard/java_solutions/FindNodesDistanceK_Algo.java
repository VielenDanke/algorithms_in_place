package tree.hard.java_solutions;

import java.util.ArrayList;

public class FindNodesDistanceK_Algo {

    private static class Program {
        // This is an input class. Do not edit.
        static class BinaryTree {
            public int value;
            public BinaryTree left = null;
            public BinaryTree right = null;

            public BinaryTree(int value) {
                this.value = value;
            }
        }

        public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            BinaryTree targetNode = findTargetNode(tree, target);
            if (targetNode == null) return list;
            findAllNodesAfterTarget(targetNode, list, k);
            findAllNodesBeforeTarget(tree, targetNode, list, k);
            return list;
        }

        private int findAllNodesBeforeTarget(BinaryTree tree, BinaryTree targetNode, ArrayList<Integer> list, int k) {
            if (tree == null) return -1;
            if (tree == targetNode) {
                return k - 1;
            }
            int left = findAllNodesBeforeTarget(tree.left, targetNode, list, k);
            if (left == 0) list.add(tree.value);
            int right = findAllNodesBeforeTarget(tree.right, targetNode, list, k);
            if (right == 0) list.add(tree.value);
            if (left == -1 && right == -1) {
                return -1;
            } else if (left == -1) {
                findAllNodesAfterTarget(tree.left, list, right - 1);
                return right - 1;
            } else if (right == -1) {
                findAllNodesAfterTarget(tree.right, list, left - 1);
                return left - 1;
            }
            return -1;
        }

        private void findAllNodesAfterTarget(BinaryTree targetNode, ArrayList<Integer> list, int k) {
            if (targetNode == null) return;
            if (k == 0) {
                list.add(targetNode.value);
                return;
            }
            findAllNodesAfterTarget(targetNode.left, list, k - 1);
            findAllNodesAfterTarget(targetNode.right, list, k - 1);
        }

        private BinaryTree findTargetNode(BinaryTree node, int target) {
            if (node == null) return null;
            if (node.value == target) return node;
            BinaryTree left = findTargetNode(node.left, target);
            if (left != null) return left;
            return findTargetNode(node.right, target);
        }
    }

}
