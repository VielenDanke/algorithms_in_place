package linked_list.hard.java_solutions;

import linked_list.Helper;

import static linked_list.Helper.*;

public class ShiftLinkedList_Algo {

    public static ListNode shiftLinkedList(ListNode head, int k) {
        // check if k in length of head list (if not calculate fit offset)
        // remove k node from the end
        // append them to the start
        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int offset = Math.abs(k) % length;
        if (offset == 0) {
            return head;
        }
        int newTailPosition = k > 0 ? length - offset : offset;
        temp = head;
        while (newTailPosition > 1) {
            temp = temp.next;
            newTailPosition--;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    //----------------------------------------------------------------------------------------

    public static ListNode shiftLinkedListBetter(ListNode head, int k) {
        var listTail = head;
        var length = 1;
        while (listTail.next != null) {
            listTail = listTail.next;
            length++;
        }
        var offset = Math.abs(k) % length;
        if (offset == 0) {
            return head;
        }
        var newTailPosition = k > 0 ? length - offset : offset;
        var newTail = head;
        for (var i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        var newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;
        return newHead;
    }
}
