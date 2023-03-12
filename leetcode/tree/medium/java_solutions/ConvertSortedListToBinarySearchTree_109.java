package leetcode.tree.medium.java_solutions;

import leetcode.tree.Helper;

import java.util.ArrayList;
import java.util.List;

import static leetcode.linked_list.Helper.*;
import static leetcode.tree.Helper.*;

public class ConvertSortedListToBinarySearchTree_109 {

    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            var list = new ArrayList<Integer>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return recursiveInsert(list, 0, list.size() - 1);
        }

        private TreeNode recursiveInsert(List<Integer> list, int left, int right) {
            if (right < left) {
                return null;
            }
            var middle = left + (right - left) / 2;
            var node = new TreeNode(list.get(middle));
            node.left = recursiveInsert(list, left, middle - 1);
            node.right = recursiveInsert(list, middle + 1, right);
            return node;
        }
    }

    static class SolutionLinkedList {

        private ListNode head;

        public TreeNode sortedListToBST(ListNode head) {
            this.head = head;
            return recursiveInsert(0, length(head) - 1);
        }

        private TreeNode recursiveInsert(int left, int right) {
            if (left > right) {
                return null;
            }
            int middle = left + (right - left) / 2;
            TreeNode leftNode = recursiveInsert(left, middle - 1);
            TreeNode node = new TreeNode(head.val);
            head = head.next;
            node.left = leftNode;
            node.right = recursiveInsert(middle + 1, right);
            return node;
        }

        private int length(ListNode node) {
            int n;
            for (n = 0; node != null; n++) {
                node = node.next;
            }
            return n;
        }
    }
}
