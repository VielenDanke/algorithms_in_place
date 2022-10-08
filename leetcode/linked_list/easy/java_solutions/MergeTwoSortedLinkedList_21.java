package leetcode.linked_list.easy.java_solutions;

import static leetcode.linked_list.Helper.ListNode;

public class MergeTwoSortedLinkedList_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode(0);
        var head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        while (list1 != null) {
            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;
        }
        while (list2 != null) {
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }
        return head.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode node;
        if (list1.val < list2.val) {
            node = list1;
            node.next = mergeTwoLists(list1.next, list2);
        } else {
            node = list2;
            node.next = mergeTwoLists(list1, list2.next);
        }
        return node;
    }
}
