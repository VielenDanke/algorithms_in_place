package leetcode.linked_list.medium.java_solution;

import static leetcode.linked_list.Helper.*;

public class RemoveNthNodeFromEndOfList_19 {

    private static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            var length = 0;

            var temp = head;

            while (temp != null) {
                length++;
                temp = temp.next;
            }
            var toRemove = length - n;

            var dummy = new ListNode(0, head);
            var result = dummy;

            while (toRemove > 0) {
                toRemove--;
                dummy = dummy.next;
            }
            dummy.next = dummy.next.next;

            return result.next;
        }
    }

    static class SolutionTwoPointers {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);

            dummy.next = head;

            ListNode slow = dummy, fast = dummy;

            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
