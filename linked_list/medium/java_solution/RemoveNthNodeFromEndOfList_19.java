package linked_list.medium.java_solution;

import linked_list.Helper;

import java.util.ArrayList;

import static linked_list.Helper.*;

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
}
