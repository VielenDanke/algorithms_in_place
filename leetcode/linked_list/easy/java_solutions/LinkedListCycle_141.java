package leetcode.linked_list.easy.java_solutions;

import java.util.HashSet;
import java.util.Set;

import static leetcode.linked_list.Helper.ListNode;

public class LinkedListCycle_141 {

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }

    static class SolutionBruteForce {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            while (head != null) {
                if (set.contains(head)) {
                    return true;
                }
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }
}
