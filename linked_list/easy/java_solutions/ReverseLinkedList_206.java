package linked_list.easy.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static linked_list.Helper.ListNode;

public class ReverseLinkedList_206 {

    public ListNode reverseListWithArray(ListNode head) {
        List<Integer> list = new ArrayList<>();

        var temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
