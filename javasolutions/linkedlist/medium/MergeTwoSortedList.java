package javasolutions.linkedlist.medium;

import javasolutions.linkedlist.ListNode;

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode temp;

        if (left.val > right.val) {
            temp = new ListNode(right.val);
            right = right.next;
        } else {
            temp = new ListNode(left.val);
            left = left.next;
        }
        ListNode result = temp;

        while (left != null && right != null) {
            if (left.val > right.val) {
                temp = new ListNode(right.val);
                right = right.next;
            } else {
                temp = new ListNode(left.val);
                left = left.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp = new ListNode(left.val);
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp = new ListNode(right.val);
            right = right.next;
            temp = temp.next;
        }
        return result;
    }
}
