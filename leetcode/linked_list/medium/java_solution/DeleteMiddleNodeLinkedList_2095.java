package leetcode.linked_list.medium.java_solution;

import leetcode.linked_list.Helper;

import static leetcode.linked_list.Helper.*;

public class DeleteMiddleNodeLinkedList_2095 {

    static class SolutionBruteForce {
        public ListNode deleteMiddle(ListNode head) {
            int length = 0;

            ListNode current = head;

            while (current != null) {
                length++;
                current = current.next;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode node = dummy;

            int toRemove = length / 2;

            while (toRemove > 0) {
                toRemove--;
                node = node.next;
            }
            node.next = node.next.next;
            return dummy.next;
        }
    }

    static class Solution {
        /*
        Fast node running 2x times faster than slow node
        Length 7
        slow points to 0
        fast points to 2

        1. slow - 1, fast - 4
        2. slow - 2, fast - 6
        3. break as fast.next == null

        slow.next = slow.next.next - we skip middle node
        return head;
         */
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode slow = head, fast = head.next.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

    static class SolutionDummyTwoPointers {
        /*
        The same idea as for slow - next, but with dummy node, slow and fast points to dymmy
         */
        public ListNode deleteMiddle(ListNode head) {
            ListNode dummy = new ListNode(-1), slow = dummy, fast = dummy;
            dummy.next = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
