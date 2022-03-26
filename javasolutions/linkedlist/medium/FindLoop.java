package javasolutions.linkedlist.medium;

import java.util.HashSet;
import java.util.Set;
import javasolutions.linkedlist.ListNode;

public class FindLoop {

    public static ListNode findLoopWithoutSet(ListNode head) {
        ListNode first = head.next;
        ListNode second = head.next.next;
        while (first != second) {
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static ListNode findLoop(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return head;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
