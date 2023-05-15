package leetcode.linked_list.medium.java_solution;

import leetcode.linked_list.Helper;

import static leetcode.linked_list.Helper.*;

public class SwappingNodesInLinkedList_1721 {

    static class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode temp = head;
            ListNode left = head;
            ListNode right = head;
            int counter = 1;
            while (counter < k) {
                left = left.next;
                right = right.next;
                counter++;
            }
            while (right.next != null) {
                temp = temp.next;
                right = right.next;
            }
            int tempVal = temp.val;
            temp.val = left.val;
            left.val = tempVal;
            return head;
        }
    }

    static class SolutionBruteForce {
        public ListNode swapNodes(ListNode head, int k) {
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            ListNode left = null;
            ListNode right = null;
            temp = head;
            for (int i = 0; i < length; i++) {
                if (i == k - 1) {
                    left = temp;
                }
                if (i == length - k) {
                    right = temp;
                }
                temp = temp.next;
            }
            if (left == null || right == null || left.equals(right)) {
                return head;
            }
            int tempVal = left.val;
            left.val = right.val;
            right.val = tempVal;
            return head;
        }
    }
}
