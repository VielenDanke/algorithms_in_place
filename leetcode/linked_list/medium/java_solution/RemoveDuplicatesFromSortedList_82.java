package leetcode.linked_list.medium.java_solution;

import static leetcode.linked_list.Helper.ListNode;

public class RemoveDuplicatesFromSortedList_82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        ListNode temp = head;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
            } else {
                dummy.next = temp;
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        dummy.next = null;
        return newHead.next;
    }

    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesRecursion(head.next);
        } else {
            head.next = deleteDuplicatesRecursion(head.next);
        }
        return head;
    }
}
