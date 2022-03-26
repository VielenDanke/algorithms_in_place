package javasolutions.linkedlist.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javasolutions.linkedlist.ListNode;

public class HasCycleLinkedList {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (slow == null && fast == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Map<Integer, Set<ListNode>> visitedNodes = new HashMap<>();

        while (head != null) {
            if (visitedNodes.containsKey(head.val)) {
                Set<ListNode> innerNodes = visitedNodes.get(head.val);
                if (innerNodes.contains(head)) {
                    return true;
                }
                innerNodes.add(head);
            } else {
                Set<ListNode> set = new HashSet<>();
                set.add(head);
                visitedNodes.put(head.val, set);
            }
            head = head.next;
        }
        return false;
    }
}
