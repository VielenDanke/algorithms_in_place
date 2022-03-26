package javasolutions.linkedlist.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javasolutions.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicatesBruteForce(ListNode head) {
        TreeMap<Integer, Integer> visited = new TreeMap<>(Comparator.comparingInt(Integer::intValue));

        while (head != null) {
            if (visited.containsKey(head.val)) {
                visited.put(head.val, visited.get(head.val) + 1);
            } else {
                visited.put(head.val, 1);
            }
            head = head.next;
        }
        List<Integer> resultNodes = visited.entrySet()
                .stream()
                .filter(entrySet -> entrySet.getValue() == 1)
                .map(Entry::getKey)
                .toList();

        ListNode temp = new ListNode(resultNodes.get(0));

        ListNode result = temp;

        for (int i = 1; i < resultNodes.size(); i++) {
            temp.next = new ListNode(resultNodes.get(i));
            temp = temp.next;
        }
        return result;
    }

    public static ListNode deleteDuplicatesIterative(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

}
